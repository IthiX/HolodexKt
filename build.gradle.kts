buildscript {

    repositories {
        google()
        maven(url = "https://jitpack.io")
        maven(url = "https://s3.amazonaws.com/salesforcesos.com/android/maven/release")
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")

    }
}

allprojects {
    repositories {
        maven (url = "https://jitpack.io")
        mavenCentral()
        google()
    }
}