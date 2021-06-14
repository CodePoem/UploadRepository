// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven(
            uri("${rootDir}/.repos")
        )
        mavenCentral()
        google()
        maven (
            uri("https://jitpack.io")
        )
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven(
            uri("${rootDir}/.repos")
        )
        mavenCentral()
        google()
        maven (
            uri("https://jitpack.io")
        )
        jcenter()
    }
}

tasks.register<Delete>(name = "clean") {
    group = "build"
    delete(rootProject.buildDir)
}