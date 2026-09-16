package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button2:Button=findViewById(R.id.button2)


        button2.setOnClickListener {
          val intent = Intent(this,MainActivity2::class.java)
           //val intent = Intent(this,Shoulder_WorkOut::class.java)
            startActivity(intent)
        }
    }
}