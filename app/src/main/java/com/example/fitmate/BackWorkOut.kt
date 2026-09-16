package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BackWorkOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_back_work_out)

        val start: Button =findViewById(R.id.button)

        start.setOnClickListener{
            startActivity(Intent(this,BackWorkOutMeediaPlayer::class.java))

        }

    }
}