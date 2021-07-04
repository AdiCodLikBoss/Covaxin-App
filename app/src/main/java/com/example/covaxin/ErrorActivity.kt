package com.example.covaxin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}