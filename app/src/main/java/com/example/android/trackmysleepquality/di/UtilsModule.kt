package com.example.android.trackmysleepquality.di

import android.content.Context
import com.example.android.trackmysleepquality.LogFormatter
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
object UtilsModule {

    @Provides
    fun provideLogFormatter(): LogFormatter {
        return object : LogFormatter {
            override fun format(log: String) = "[$log]"
        }
    }
}