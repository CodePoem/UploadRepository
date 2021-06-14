# UploadRepository

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-base-android/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-base-android)

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-android/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-android)

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-kotlin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-kotlin)

[![](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.codepoem/demo-lib-java)

[English Doc](README.md)

上传发布的 gradle 脚本。

jcenter bintray 已废弃。

如果你仍旧像想使用老的方式使用之前的 jcenter 或 jitpack，请切换到 [old](https://github.com/CodePoem/UploadRepository/tree/old) 分支。

## 如何使用

1. 注册 [sonatype](https://issues.sonatype.org/) 账号并安装 gpg（秘钥生成工具）生成秘钥.

项目根目录下 local.properties 添加属性:

```properties
sonatype.username=password
sonatype.password=password
```

项目根目录下或者 gradle 根目录下($User/.gradle) gradle.properties 添加属性:

```properties
signing.keyId=secretKeyId
signing.password=secretPassword
signing.secretKeyRingFile=secretKeyRingFile
```

2. 在你需要上传发布的模块的 build.gradle 的最后一行引入以下代码。

可以直接使用远程 Url 地址，也可以拷贝到本地，应用上传脚本：

```gradle
apply from:'https://raw.githubusercontent.com/CodePoem/UploadRepository/main/mavencentral/publish.gradle.kts'
```

kotlin:

```kotlin
apply(from = "https://raw.githubusercontent.com/CodePoem/UploadRepository/main/mavencentral/publish.gradle.kts")
```

3. 在 gradle.properties 中添加对应的公共配置。

(1) 项目根目录 gradle.properties 添加版本信息和发布的 pom 信息。

版本信息:

```properties
pkgGroupId=io.github.upload-repository
pkgVersion=1.0.0
```

pom 信息:

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

(2) 子项目添加 pkgArtifactId 属性。

```properties
pkgArtifactId=XXX
```

4. 项目任务中找到 publishing 分组并运行 publish 任务。

5. 登录 [sonatype maven](https://s01.oss.sonatype.org/) 处理上传。

## Kotlin JavaDoc

使用 javadoc 插件 [org.jetbrains.dokka](https://plugins.gradle.org/plugin/org.jetbrains.dokka).

```kotlin
val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
}
```