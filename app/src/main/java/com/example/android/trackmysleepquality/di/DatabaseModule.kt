package com.example.android.trackmysleepquality.di

import android.content.Context
import androidx.room.Room
import com.example.android.trackmysleepquality.database.SleepDatabase
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    enum class DevelopmentMode {
        DEVELOP, DEBUG
    }
    val developmentMode = DevelopmentMode.DEBUG

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): SleepDatabase {
        return when(developmentMode) {
            DevelopmentMode.DEBUG -> SleepDatabase.getInstance(appContext)
            DevelopmentMode.DEVELOP -> Room.inMemoryDatabaseBuilder(appContext,
                    SleepDatabase::class.java).build()
        }
    }

    @Provides
    fun provideLogDao(database: SleepDatabase): SleepDatabaseDao {
        return database.sleepDatabaseDao
    }
}