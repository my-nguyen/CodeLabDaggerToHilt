package com.nguyen.codelabdaggertohilt.di

import com.nguyen.codelabdaggertohilt.user.UserComponent
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// This module tells a Component which are its subcomponents
@InstallIn(SingletonComponent::class)
@Module(subcomponents = [UserComponent::class])
class AppSubcomponents
