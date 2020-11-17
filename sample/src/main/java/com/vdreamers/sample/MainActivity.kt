package com.vdreamers.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vdreamers.demo.base.android.HelloBaseAndroid
import com.vdreamers.demo.lib.android.HelloAndroid
import com.vdreamers.demo.lib.java.HelloJava
import com.vdreamers.demo.lib.kotlin.HelloKotlin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HelloJava.helloJava()
        HelloKotlin.helloKotlin()
        HelloBaseAndroid.helloBaseAndroid()
        HelloAndroid.helloAndroid()
    }
}