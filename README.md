# SleepTracker

Simple app that helps you collect information about your sleep. It lets you track start time, end time, quality, and time slept.

This is the toy app for Lesson 7 of the [Android App Development in Kotlin] course on Udacity.

This app demonstrates the following views and techniques:
- Room database, DAO, and Coroutines
- Transformation map
- Data Binding in XML files
- ViewModel Factory
- Using Backing Properties to protect MutableLiveData
- Observable state LiveData variables to trigger navigation

(previous note: to make Room compile on M1 macs you need to add `kapt "org.xerial:sqlite-jdbc:3.36.0"` before kapt for room. this problem went away with room 2.4)

----

[Android App Development in Kotlin]: https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012

----

Environment

- Kotlin 1.7.10
- Android Studio Bumblebee 2021.2.1
- Gradle Plugin 7.2.2

----

updated: 2022-03-06