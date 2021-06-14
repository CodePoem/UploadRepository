import com.vdreamers.version.AppBuildConfigs
import com.vdreamers.version.Deps
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(AppBuildConfigs.COMPILE_SDK_VERSION)
    buildToolsVersion(AppBuildConfigs.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId(AppBuildConfigs.APPLICATION_ID)
        minSdkVersion(AppBuildConfigs.MIN_SDK_VERSION)
        targetSdkVersion(AppBuildConfigs.TARGET_SDK_VERSION)
        versionCode(AppBuildConfigs.VERSION_CODE)
        versionName(AppBuildConfigs.VERSION_NAME)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    signingConfigs {
        val fis = FileInputStream("${rootProject.projectDir}/local.properties")
        val properties = Properties().apply {
            load(fis)
        }
        val releaseKeyPath: String = properties.getProperty("release.keystore.path") ?: ""
        val releaseKeyPassword: String = properties.getProperty("release.keystore.password") ?: ""
        val releaseKeyAlias: String = properties.getProperty("release.keystore.alias") ?: ""
        val releaseKeyAliasPassword: String =
            properties.getProperty("release.keystore.aliasPassword") ?: ""

        create("release") {
            keyAlias = releaseKeyAlias
            keyPassword = releaseKeyAliasPassword
            storeFile = file(releaseKeyPath)
            storePassword = releaseKeyPassword
        }
    }

    flavorDimensions("channel", "env")
    productFlavors {
        create("official") {
            dimension("channel")
        }
        create("unofficial") {
            dimension("channel")
        }
        create("internal") {
            applicationId(AppBuildConfigs.APPLICATION_ID_INTERNAL)
            dimension("env")
        }
        create("production") {
            applicationId(AppBuildConfigs.APPLICATION_ID)
            dimension("env")
        }
    }

    buildTypes {
        val debug = getByName("debug")
        debug.apply {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-Debug"
            debuggable(true)
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        val release = getByName("release")
        release.apply {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        val beta = create("beta")
        beta.apply {
            initWith(release)
            applicationIdSuffix = ".beta"
            versionNameSuffix = "-Beta"
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
    implementation(Deps.AndroidX.coreKtx())
    implementation(Deps.AndroidX.appcompat())
    implementation(Deps.AndroidX.constraintLayout())
    implementation(Deps.Google.material())

    implementation(project(":demo-base-android"))
    implementation(project(":demo-lib-android"))
    implementation(project(":demo-lib-java"))
    implementation(project(":demo-lib-kotlin"))

    testImplementation(Deps.Test.junit())
    androidTestImplementation(Deps.AndroidTest.junit())
    androidTestImplementation(Deps.AndroidTest.espressoCore())
}