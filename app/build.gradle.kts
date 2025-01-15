plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.androidx.navigation.safe.args)
}

android {
    namespace = "com.cmc.ruty_android"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.cmc.ruty_android"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        buildConfig = true // git 코드 시크릿 키 올리면 안된, 로컬 프로퍼티스에 그 값을 끌어다가 config처럼,
        // 상수값들이 들어갈 수 있게, git에 안올라가게, graddle 8.0이상 쓰니까한다.
        // 깃에 안올라가는 로컬 파일 생성
    }
    viewBinding {
        enable = true
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.bundles.kotlinx.coroutine)
    implementation(libs.bundles.androidx.navigation)
    implementation(libs.bundles.lifecycle)
    implementation(libs.gson.gson)
    implementation(libs.squareup.retrofit2)
    implementation(libs.squareup.gson.converter)
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.okhttp.interceptor)

    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}