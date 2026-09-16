package com.example.fitmate

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class cardio_media : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cardio_media)
        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.joging_walking))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.jumping_jacks))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.high_knees))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.burpees))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.butt_kicks))


        text.add("Running or Jogging\n" + "\n" + "Pace: Moderate, maintain a steady pace that elevates your heart rate but allows you to sustain the activity for the entire duration.")
        text.add("Jumping Jacks\n" + "\n" + "Duration: 45 seconds\n" + "Rest: 15 seconds\n")
        text.add("High Knees\n" + "\n" + "Duration: 45 seconds\n" + "Rest: 15 seconds\n")
        text.add("Burpees\n" + "\n" + "Duration: 45 seconds\n" + "Rest: 15 seconds")
        text.add("Butt Kicks\n" + "\n" + "Duration: 45 seconds\n" + "Rest: 15 seconds")







        val mediaController= MediaController(this)
        mediaController.setAnchorView(video)
        video.setMediaController(mediaController)

        video.setVideoURI(videoUris[currentVideoIndex])
        video.start()

        val textwla: TextView =findViewById(R.id.textViewChest)

        textwla.setText(text[currentVideoIndex])

        val next: Button =findViewById(R.id.next)
        val prev: Button =findViewById(R.id.previous)


        next.setOnClickListener{
            if (currentVideoIndex < videoUris.size - 1) {
                currentVideoIndex++
                video.setVideoURI(videoUris[currentVideoIndex])
                video.start()
                textwla.setText(text[currentVideoIndex])


            }else{
                Toast.makeText(this, "No Next Video", Toast.LENGTH_SHORT).show()
            }


        }
        prev.setOnClickListener{
            if (currentVideoIndex > 0) {
                currentVideoIndex--
                video.setVideoURI(videoUris[currentVideoIndex])
                video.start()
                textwla.setText(text[currentVideoIndex])
            }else{
                Toast.makeText(this, "No Previous Video", Toast.LENGTH_SHORT).show()
            }



        }





    }
}