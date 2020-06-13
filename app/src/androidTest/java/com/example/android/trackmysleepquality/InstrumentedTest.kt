package com.example.android.trackmysleepquality

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.android.trackmysleepquality.database.*
import com.example.android.trackmysleepquality.di.DatabaseModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.delay
import org.hamcrest.Matchers.containsString
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Singleton

@RunWith(AndroidJUnit4::class)
@UninstallModules(DatabaseModule::class)
@HiltAndroidTest
class AppTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Module
    @InstallIn(ApplicationComponent::class)
    object TestModule {

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext appContext: Context): SleepDatabase {
            return Room.inMemoryDatabaseBuilder(
                    appContext,
                    SleepDatabase::class.java
            ).build()
        }

        @Provides
        fun provideDao(database: SleepDatabase): SleepDatabaseDao {
            return database.sleepDatabaseDao
        }
    }


    @Test
    fun happyPath() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.start_button)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.stop_button)).perform(click())
        onView(withText(containsString("How was your sleep?")))
                .check(matches(isDisplayed()))
        pressBack()
    }
}
