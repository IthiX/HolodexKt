plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.ithix.holodex"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ithix.holodex"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false //TODO Change to TRUE after implementing more build types
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.1"
    }
    packagingOptions {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }

//    flavorDimensions += "default"

//    productFlavors {
//        create("release") {
//            dimension = "default"
//            addManifestPlaceholders(mapOf<String, Any>(
//                "appName" to "Holodex Release"
//            ))
//        }
//    }
}

dependencies {
    val dagger = "2.44"
    val coroutines = "1.6.4"
    val lifecycle = "2.6.1"

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")

    // lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1") {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }

    //Holodex internal
    internalModule(":holodex-kt")
}

fun DependencyHandlerScope.internalModule(dependecy: String) = add("implementation", project(dependecy))