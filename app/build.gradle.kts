plugins {
    id("com.android.application")
}

android {
    namespace = "br.com.becker.connect"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.becker.connect"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
