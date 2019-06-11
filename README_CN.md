# UploadRepository
上传发布的gradle脚本。

[English Doc](README.md)

## 如何使用

1. 在你根项目的build.gradle的dependencies节点添加以下classpath。

```
dependencies {
        classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4'
    }
``` 

2. 在你需要上传发布的模块的build.gradle的最后一行引入以下代码。

```
apply from:'https://raw.githubusercontent.com/CodePoem/UploadRepository/master/bintray/uploadBintray.gradle'
```

3. 在gradle.properties中添加对应的公共配置。

你可以参考 gradleExample4Aar.properties 和 gradleExample4Jar.properties。

4. 在local.properties中添加对应的私密配置。

你可以参考 localExample.properties。

## 异常处理

### JavaDoc

#### 修复 JavaDoc UTF-8 编码问题

请使用uploadBintrayNoJavadoc.gradle无Javadoc上传。

```
apply from:'https://raw.githubusercontent.com/CodePoem/UploadRepository/master/bintray/uploadBintrayNoJavadoc.gradle'
```

## 其他

上传到 bintray(Jencter) 可能需要科学上网。