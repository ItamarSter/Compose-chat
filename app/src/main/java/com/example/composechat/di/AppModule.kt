package com.example.composechat.di

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.composechat.local.DataStoreRepository
import com.example.composechat.local.SharedPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    // just my preference of naming including the package name
    name = "com.example.composechat.user_preferences"
)

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(dataStore: DataStore<Preferences>): DataStoreRepository {
        return DataStoreRepository(dataStore)
    }

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) = context.dataStore

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(sharedPreferences: SharedPreferences): SharedPreferencesRepository {
        return SharedPreferencesRepository(sharedPreferences)
    }
}