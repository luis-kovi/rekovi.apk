package com.rekovi.taskmanager.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.rekovi.taskmanager.data.repository.AuthRepository
import com.rekovi.taskmanager.data.repository.AuthRepositoryImpl
import com.rekovi.taskmanager.data.repository.TaskRepository
import com.rekovi.taskmanager.data.repository.TaskRepositoryImpl
import com.rekovi.taskmanager.data.source.local.PreferencesManager
import com.rekovi.taskmanager.data.source.remote.SupabaseClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "rekovi_preferences"
)

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }

    @Provides
    @Singleton
    fun providePreferencesManager(dataStore: DataStore<Preferences>): PreferencesManager {
        return PreferencesManager(dataStore)
    }

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return SupabaseClient()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        supabaseClient: SupabaseClient,
        preferencesManager: PreferencesManager
    ): AuthRepository {
        return AuthRepositoryImpl(supabaseClient, preferencesManager)
    }

    @Provides
    @Singleton
    fun provideTaskRepository(
        supabaseClient: SupabaseClient
    ): TaskRepository {
        return TaskRepositoryImpl(supabaseClient)
    }
}

