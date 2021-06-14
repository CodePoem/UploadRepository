package com.vdreamers.demo.lib.android

import com.vdreamers.demo.lib.java.HelloJava
import com.vdreamers.demo.lib.kotlin.HelloKotlin

object HelloAndroid {

    fun helloAndroid() {
        println("HelloAndroid~")
        HelloJava.helloJava()
        HelloKotlin.helloKotlin()
    }
}