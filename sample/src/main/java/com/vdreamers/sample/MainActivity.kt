package com.vdreamers.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vdreamers.demo.lib.android.HelloAndroid

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HelloAndroid.helloAndroid()
    }
}