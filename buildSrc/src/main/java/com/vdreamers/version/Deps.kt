package com.vdreamers.version

enum class Deps {
    ;

    object Kotlin {
        private const val KOTLIN_VERSION = "1.3.72"

        fun stdlib(version: String = KOTLIN_VERSION): String {
            return "org.jetbrains.kotlin:kotlin-stdlib:$version"
        }
    }

    object AndroidX {
        private const val CORE_KTX_VERSION = "1.3.2"
        private const val APPCOMPAT_VERSION = "1.2.0"
        private const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"

        fun coreKtx(version: String = CORE_KTX_VERSION): String {
            return "androidx.core:core-ktx:$version"
        }

        fun appcompat(version: String = APPCOMPAT_VERSION): String {
            return "androidx.appcompat:appcompat:$version"
        }

        fun constraintLayout(version: String = CONSTRAINT_LAYOUT_VERSION): String {
            return "androidx.constraintlayout:constraintlayout:$version"
        }
    }

    object Google {
        private const val MATERIAL_VERSION = "1.3.0"

        fun material(version: String = MATERIAL_VERSION): String {
            return "com.google.android.material:material:$version"
        }
    }

    object Test {
        private const val JUNIT_VERSION = "4.13.2"

        fun junit(version: String = JUNIT_VERSION): String {
            return "junit:junit:$version"
        }
    }

    object AndroidTest {
        private const val JUNIT_VERSION = "1.1.2"
        private const val ESPRESSO_CORE_VERSION = "3.3.0"

        fun junit(version: String = JUNIT_VERSION): String {
            return "androidx.test.ext:junit:$version"
        }

        fun espressoCore(version: String = ESPRESSO_CORE_VERSION): String {
            return "androidx.test.espresso:espresso-core:$version"
        }
    }

    object CodePoem {
        private const val FIRE_CORE_VERSION = "1.0.0"
        private const val FIRE_VERSION = "1.0.0"

        fun fireCore(version: String = FIRE_CORE_VERSION): String {
            return "io.github.codepoem:fire-core:$version"
        }

        fun fire(version: String = FIRE_VERSION): String {
            return "io.github.codepoem:fire:$version"
        }

    }

    object VDreamers {
        private const val V_ANDROID_EXT= "1.0.1"
        private const val V_KOTLIN_EXT = "1.0.1"

        fun vAndroidExt(version: String = V_ANDROID_EXT): String {
            return "io.github.codepoem:v-android-ext:$version"
        }

        fun vKotlinExt(version: String = V_KOTLIN_EXT): String {
            return "io.github.codepoem:v-kotlin-ext:$version"
        }
    }
}