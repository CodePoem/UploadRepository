package com.vdreamers.demo.lib.android

import com.vdreamers.demo.base.android.HelloBaseAndroid

import com.vdreamers.demo.lib.java.HelloJava
import com.vdreamers.demo.lib.kotlin.HelloKotlin

object HelloAndroid {

    fun helloAndroid() {
        println("HelloAndroid~")
        HelloBaseAndroid.helloBaseAndroid()
        HelloJava.helloJava()
        HelloKotlin.helloKotlin()
    }
}