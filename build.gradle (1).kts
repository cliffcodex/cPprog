import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}

android {
    namespace = "com.west.%"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.west.%"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++17"
            }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {
    // Core dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // Jetpack Compose dependencies
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.activity:activity-ktx:1.10.1") // ✅ Add this line
    implementation("androidx.compose.ui:ui:1.8.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.8.2")
    debugImplementation("androidx.compose.ui:ui-tooling:1.8.2")

    // Navigation for Jetpack Compose
    implementation("androidx.navigation:navigation-compose:2.9.0")

    // Lifecycle dependencies (LiveData and ViewModel)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0")

    // Optional testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Optional: Jetpack Compose runtime with LiveData
    implementation("androidx.compose.runtime:runtime-livedata:1.8.2")

    // Preferences DataStore
    implementation ("androidx.datastore:datastore-preferences:1.1.7")

    //Json
    implementation ("com.google.code.gson:gson:2.11.0")

    // Google Font
    implementation("androidx.compose.ui:ui-text-google-fonts:1.8.2")

    //BoxWithConstraints
    implementation ("androidx.compose.ui:ui:1.8.2")
    implementation ("androidx.compose.foundation:foundation-layout:1.8.2")

    // scrollable row with a circular indicator
    implementation("androidx.compose.material3:material3:1.3.2")
    implementation ("androidx.compose.foundation:foundation:1.8.2")

    //Google Pager
    implementation ("com.google.accompanist:accompanist-pager:0.30.1")

    // Jetpack ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7" +
            ".0")

    // Kotlin coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // If using StateFlow and Compose together
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.9.0")

}
