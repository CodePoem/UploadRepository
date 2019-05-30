# UploadRepository 

[中文文档](README_CN.md)

gradle scripts for upload repository.


## How to Use

1. Add next classpath at the node of dependencies in your project build.gradle.

```
dependencies {
        classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4'
    }
``` 

2. Add next apply code at last line in your module build.gradle.

```
apply from:'https://raw.githubusercontent.com/CodePoem/UploadRepository/master/bintray/uploadBintray.gradle'
```

3. Add pulic setting in gradle.properties.

You can refer gradleExample4Aar.properties and gradleExample4Jar.properties.

4. Add secret setting in local.properties.

You can refer localExample.properties.

## Exception

### JavaDoc

#### fix JavaDoc UTF-8 Encode

Add next code at the node of allprojects in your project build.gradle.

```
allprojects {
    // javadoc encode
    tasks.withType(Javadoc) {
        options{
            encoding "UTF-8"
            charSet 'UTF-8'
        }
    }
}
```