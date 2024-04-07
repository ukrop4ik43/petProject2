plugins {
    id("java-library")
    id("kotlin-kapt")
    alias(libs.plugins.jetbrainsKotlinJvm)

}





java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")
    implementation ("com.google.dagger:dagger:2.50")
    kapt ("com.google.dagger:dagger-compiler:2.50")
}