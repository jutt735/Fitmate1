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

class ChestWorkMediaPlayer : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chest_work_media_player)

        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.pushups))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.flat_chest_press))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.decline_dumbell_chestpress))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.inclined_chestpress))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.chest_dips))


        text.add("Push-Ups\n"+"Sets: 3\n"+"Reps: To failure\n"+"Rest: 60 seconds\n"+"Instructions: Perform traditional push-ups, ensuring your body stays in a straight line from head to heels and you lower your chest to the ground.\n")
        text.add("Flat Chest Press by Machine\n"+"Sets: 3\n" +"Reps: 8-12\n"+"Rest: 60-90 seconds\n"+"Instructions: Sit at the chest press machine, set the handles at chest level, and press the handles forward until your arms are extended. Return slowly to the starting position.\n")
        text.add("Decline Dumbbell Press\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Rest: 60-90 seconds\n"+"Instructions: Set a decline bench to about 30 degrees, hold a dumbbell in each hand, and press them upwards from your shoulders until your arms are extended.\n")
        text.add("Incline Dumbbell Press\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Rest: 60-90 seconds\n"+"Instructions: Set an incline bench to about 30-45 degrees, hold a dumbbell in each hand, and press them upwards from your shoulders until your arms are extended.\n")
        text.add("Chest Dips\n"+"Sets: 3\n"+"Reps: To failure\n"+"Rest: 60 seconds\n"+"Instructions: Use parallel bars and lean slightly forward, lowering your body until your upper arms are parallel to the ground, then push back up.")








        val mediaController= MediaController(this)
        mediaController.setAnchorView(video)
        video.setMediaController(mediaController)

        video.setVideoURI(videoUris[currentVideoIndex])
        video.start()

        val textwla:TextView=findViewById(R.id.textViewChest)

        textwla.setText(text[currentVideoIndex])

        val next:Button=findViewById(R.id.next)
        val prev:Button=findViewById(R.id.previous)


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