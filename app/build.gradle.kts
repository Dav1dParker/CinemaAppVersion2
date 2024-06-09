plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cinemaapp2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cinemaapp2"
        minSdk = 31
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // viewpager2
    implementation("androidx.viewpager2:viewpager2:1.1.0")

    implementation ("com.github.bumptech.glide:glide:4.12.0")

    implementation("com.android.volley:volley:1.2.1")
    implementation("com.google.code.gson:gson:2.10.1")


    //
    implementation ("com.readystatesoftware.sqliteasset:sqliteassethelper:2.0.1")
    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation ("androidx.cardview:cardview:1.0.0")

}