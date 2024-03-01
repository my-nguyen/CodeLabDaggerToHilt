package com.nguyen.codelabdaggertohilt.di

import com.nguyen.codelabdaggertohilt.login.LoginComponent
import com.nguyen.codelabdaggertohilt.registration.RegistrationComponent
import com.nguyen.codelabdaggertohilt.user.UserComponent
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck

// This module tells a Component which are its subcomponents
@InstallIn(SingletonComponent::class)
@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubcomponents
