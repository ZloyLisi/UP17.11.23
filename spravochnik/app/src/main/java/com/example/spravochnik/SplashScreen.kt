package com.example.spravochnik

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.spravochnik.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity()


    {private lateinit var binding:ActivitySplashScreenBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashScreen()

        binding.imageView3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.drawable.anim_show))
    }





    private fun splashScreen() {
    val imageView: ImageView = findViewById(R.id.imageView)
    imageView.setBackgroundResource(R.drawable.avd_anim)
    val animation = imageView.background as AnimatedVectorDrawable
    animation.start()
    val splashTime: Long = 2500
    Handler(Looper.getMainLooper()).postDelayed({
        val intent= Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
        finish()
    },splashTime)}

}