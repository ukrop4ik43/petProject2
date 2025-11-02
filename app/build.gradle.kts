plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.pettpro.expenceche"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pettpro.expenceche"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.navigation.compose)
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)
    implementation (libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.material3)
    // Navigation Compose
    implementation (libs.androidx.compose.material)
    implementation (libs.androidx.compose.runtime.livedata)
    implementation (libs.accompanist.pager)
    // Pager and Indicators - Accompanist
    implementation (libs.accompanist.pager.v0242alpha)
    implementation (libs.accompanist.pager.indicators)

    implementation( libs.androidx.hilt.navigation.compose)
    implementation (libs.androidx.room.runtime)
    kapt (libs.androidx.room.compiler)

    // Optional: For Kotlin coroutine support
    implementation (libs.androidx.room.ktx)

    implementation (libs.gson)

    implementation(platform(libs.firebase.bom))
    implementation(libs.com.google.firebase.firebase.database)


}