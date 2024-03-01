package com.nguyen.codelabdaggertohilt.di

import com.nguyen.codelabdaggertohilt.storage.SharedPreferencesStorage
import com.nguyen.codelabdaggertohilt.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

// Tells Dagger this is a Dagger module
@Module
@DisableInstallInCheck
abstract class StorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}
