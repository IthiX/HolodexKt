plugins {
    id("kotlin-kapt")
    id("kotlin-android")
    id("com.android.library")
    id("maven-publish")
}

repositories {
    google()
    maven(url = "https://jitpack.io")
    mavenCentral()
    gradlePluginPortal()
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

android {
    namespace = "com.ithix.holodex"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false //TODO Change to TRUE after implementing more build types
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
}

dependencies {
    val dagger = "2.44"
    val coroutines = "1.6.4"
    val lifecycle = "2.6.1"
    val retrofit = "2.9.0"
    val mockito = "3.7.0"
    val mockk = "1.13.5"
    val roomVersion = "2.5.1"

    implementation("androidx.core:core-ktx:1.10.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1") {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }

    // dagger2
    implementation("com.google.dagger:dagger:$dagger")
    implementation("com.google.dagger:dagger-android-support:2.35.1")
    kapt("com.google.dagger:dagger-android-processor:2.35.1")
    kapt("com.google.dagger:dagger-compiler:$dagger")
}

configure<PublishingExtension> {
    publications.create<MavenPublication>("holodexKt") {

        groupId = "com.github.IthiX"
        artifactId = "holodex-kt"
        version = "1.0.0"
    }
    repositories {
        mavenLocal()
    }
}



fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}