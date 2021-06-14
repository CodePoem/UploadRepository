import com.vdreamers.version.Deps

plugins {
    id("java-library")
    id("kotlin")
    id("org.jetbrains.dokka") version "1.4.32"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Deps.Kotlin.stdlib())
}

val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
}

apply(from = "${rootProject.projectDir}/mavencentral/publish.gradle.kts")
