package com.vdreamers.demo.lib.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_lib_android_activity_main)

        HelloAndroid.helloAndroid()
    }
}