# UploadRepository

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-base-android/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-base-android)

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-android/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-android)

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-kotlin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-kotlin)

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-java)

[中文文档](README_CN.md)

gradle scripts for upload repository.

jcenter bintray is deprecated.

If you still want to use jcenter or jitpack with old upload scripts, please switch branch [old](https://github.com/CodePoem/UploadRepository/tree/old).

## How to Use

1. register [sonatype](https://issues.sonatype.org/) and install gpg to generate secret key.

root project local.properties add properties:

```properties
sonatype.username=password
sonatype.password=password
```

root project or gradle home($User/.gradle) gradle.properties add properties:

```properties
signing.keyId=secretKeyId
signing.password=secretPassword
signing.secretKeyRingFile=secretKeyRingFile
```

2. Add apply code at last line in your module build.gradle.

remote url or copy to local, apply upload scripts.

```gradle
apply from:'https://raw.githubusercontent.com/CodePoem/UploadRepository/main/mavencentral/publish.gradle.kts'
```

kotlin:

```kotlin
apply(from = "https://raw.githubusercontent.com/CodePoem/UploadRepository/main/mavencentral/publish.gradle.kts")
```

3. Add public setting in gradle.properties.

(1) root project gradle.properties add versionInfo and pomInfo.

versionInfo:

```properties
pkgGroupId=io.github.upload-repository
pkgVersion=1.0.0
```

pomInfo:

```properties
pomName=UploadRepository
pomDescription=gradle scripts for upload repository.
pomUrl=https://github.com/CodePoem/UploadRepository
pomLicenseName=The Apache License, Version 2.0
pomLicenseUrl=http://www.apache.org/licenses/LICENSE-2.0.txt
pomDeveloperName=CodePoem
pomDeveloperEmail=codepoemfun@gmail.com
pomScmUrl=https://github.com/CodePoem/UploadRepository
pomScmConnection=scm:git:github.com/CodePoem/UploadRepository.git
pomScmDeveloperConnection=scm:git:ssh://git@github.com/CodePoem/UploadRepository.git
```

(2) subProject add pkgArtifactId property.

```properties
pkgArtifactId=XXX
```

4. project tasks find publishing group and run publish task.

5. login [sonatype maven](https://s01.oss.sonatype.org/) to handle upload.

## Kotlin JavaDoc

use javadoc plugin [org.jetbrains.dokka](https://plugins.gradle.org/plugin/org.jetbrains.dokka).

```kotlin
val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
}
```
