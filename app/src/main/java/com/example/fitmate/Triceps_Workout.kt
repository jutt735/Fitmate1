package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Triceps_Workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triceps_workout)
        val start: Button =findViewById(R.id.button)

        start.setOnClickListener{
            startActivity(Intent(this,Triceps_Workout_MediaPlayer::class.java))

        }
    }
}