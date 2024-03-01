package com.nguyen.codelabdaggertohilt.di

import com.nguyen.codelabdaggertohilt.storage.FakeStorage
import com.nguyen.codelabdaggertohilt.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

// Overrides StorageModule in android tests
@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [StorageModule::class])
abstract class TestStorageModule {

    // Makes Dagger provide FakeStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}
