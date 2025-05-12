
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.west.calculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.west.calculator"
        minSdk = 24
        targetSdk = 34

        ndk {
            abiFilters += listOf("armeabi-v7a", "x86")
        }

        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }

        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }
}

dependencies {
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.material3:material3:1.2.0")
}
