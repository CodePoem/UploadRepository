import com.vdreamers.version.Deps

plugins {
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Deps.Kotlin.stdlib())
}

val javadoc by tasks.getting(org.gradle.api.tasks.javadoc.Javadoc::class)

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn.add(javadoc)
    archiveClassifier.set("javadoc")
    from(javadoc)
}

apply(from = "${rootProject.projectDir}/mavencentral/publish.gradle.kts")
