// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    kotlin("kapt") version "1.9.0"
    alias(libs.plugins.androidLibrary) apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
}


buildscript {
        dependencies {
        classpath (libs.hilt.android.gradle.plugin)
        classpath (libs.google.services)
    }
}