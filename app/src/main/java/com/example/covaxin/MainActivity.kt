package com.example.covaxin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.covaxin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation1 = AnimationUtils.loadAnimation(this,R.anim.myanimation1)
        val animation2 = AnimationUtils.loadAnimation(this,R.anim.myanimation2)
        View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.tv1.startAnimation(animation1)
        binding.tv2.startAnimation(animation2)

       Handler().postDelayed({
            startActivity(Intent(this,Details::class.java))
            finish()
                             },
       3000
       )

    }
}