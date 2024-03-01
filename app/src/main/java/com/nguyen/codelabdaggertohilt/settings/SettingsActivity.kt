package com.nguyen.codelabdaggertohilt.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.codelabdaggertohilt.MyApplication
import com.nguyen.codelabdaggertohilt.R
import com.nguyen.codelabdaggertohilt.login.LoginActivity
import com.nguyen.codelabdaggertohilt.main.MainActivity
import com.nguyen.codelabdaggertohilt.user.UserManager
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {
    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var settingsViewModel: SettingsViewModel
    @Inject
    lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupViews()
    }

    private fun setupViews() {
        findViewById<Button>(R.id.refresh).setOnClickListener {
            settingsViewModel.refreshNotifications()
        }
        findViewById<Button>(R.id.logout).setOnClickListener {
            settingsViewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
