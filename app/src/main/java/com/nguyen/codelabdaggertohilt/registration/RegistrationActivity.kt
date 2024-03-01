package com.nguyen.codelabdaggertohilt.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.codelabdaggertohilt.MyApplication
import com.nguyen.codelabdaggertohilt.R
import com.nguyen.codelabdaggertohilt.main.MainActivity
import com.nguyen.codelabdaggertohilt.registration.enterdetails.EnterDetailsFragment
import com.nguyen.codelabdaggertohilt.registration.termsandconditions.TermsAndConditionsFragment
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity() {
    @InstallIn(SingletonComponent::class)
    @EntryPoint
    interface RegistrationEntryPoint {
        fun registrationComponent(): RegistrationComponent.Factory
    }

    // Stores an instance of RegistrationComponent so that its Fragments can access it
    lateinit var registrationComponent: RegistrationComponent

    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val entryPoint = EntryPointAccessors.fromApplication(applicationContext, RegistrationEntryPoint::class.java)
        registrationComponent = entryPoint.registrationComponent().create()

        // Injects this activity to the just created Registration component
        registrationComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()
    }

    /**
     * Callback from EnterDetailsFragment when username and password has been entered
     */
    fun onDetailsEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    /**
     * Callback from T&CsFragment when TCs have been accepted
     */
    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
