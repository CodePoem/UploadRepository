import com.vdreamers.version.AppBuildConfigs
import com.vdreamers.version.Deps

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    resourcePrefix("upload_lib_android_")
    compileSdkVersion(AppBuildConfigs.COMPILE_SDK_VERSION)
    buildToolsVersion(AppBuildConfigs.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AppBuildConfigs.MIN_SDK_VERSION)
        targetSdkVersion(AppBuildConfigs.TARGET_SDK_VERSION)
        versionCode(AppBuildConfigs.VERSION_CODE)
        versionName(AppBuildConfigs.VERSION_NAME)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        val debug = getByName("debug")
        debug.apply {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        val release = getByName("release")
        release.apply {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        val beta = create("beta")
        beta.apply {
            initWith(release)
            debuggable(true)
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Deps.Kotlin.stdlib())
    implementation(Deps.AndroidX.appcompat())
    implementation(Deps.AndroidX.constraintLayout())

    implementation(project(":demo-lib-java"))
    implementation(project(":demo-lib-kotlin"))

    testImplementation(Deps.Test.junit())
    androidTestImplementation(Deps.AndroidTest.junit())
    androidTestImplementation(Deps.AndroidTest.espressoCore())
}

apply(from = "${rootProject.projectDir}/mavencentral/publish.gradle.kts")
