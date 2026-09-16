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

class Legs_MediaPlayer : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_legs_media_player)
        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.squats))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.romanian_deadlifts))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.step_ups))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.leg_press))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.calf_raises))


        text.add("Squats\n"+"\n"+"Sets: 3\n"+"Reps: 12-15\n"+"Tips: Stand with your feet shoulder-width apart. Lower your hips back and down as if sitting in a chair, keeping your chest up and knees in line with your toes.\n")
        text.add("Romanian Deadlifts\n"+"\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Tips: Hold dumbbells in front of your thighs. Hinge at your hips, keeping a slight bend in your knees and your back straight, lowering the weights until you feel a stretch in your hamstrings. Return to the starting position.\n")
        text.add("Step-Ups\n"+"\n"+"Sets: 3\n"+"Reps: 12-15 (each leg)\n"+"Tips: Step up onto a bench or sturdy platform with one leg, then bring the other leg up to join it. Step back down and switch legs.\n")
        text.add("Leg Press (if available)\n"+"\n"+"Sets: 3\n"+"Reps: 12-15\n"+"Tips: Position your feet shoulder-width apart on the platform. Push the platform away by extending your legs, then slowly return to the starting position.\n")
        text.add("Calf Raises\n"+"\n"+"Sets: 3\n"+"Reps: 15-20\n"+"Tips: Stand with your feet hip-width apart. Raise your heels as high as possible, then lower them back down with control.")











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