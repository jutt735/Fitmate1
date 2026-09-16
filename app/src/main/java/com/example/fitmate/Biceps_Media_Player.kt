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

class Biceps_Media_Player : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_biceps_media_player)
        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.dumbbell_curls_b))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.hammer_curls))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.concentration_curls_b))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.incline_dumbbell_curls_b))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.preacher_curls))


        text.add("Standing Dumbbell Curls\n"+"\n" +"Sets: 3\n"+"Reps: 8-12\n"+"Tips: Keep your elbows close to your torso. Curl the dumbbells while contracting your biceps, then slowly lower them back to the starting position.\n")
        text.add("Hammer Curls\n" + "\n" +"Sets: 3\n"+"Reps: 10-12\n"+"Tips: Hold the dumbbells with your palms facing your torso. Curl the weights while keeping your elbows close to your body, and focus on the brachialis muscle.\n" )
        text.add("Concentration Curls\n"+"\n"+"Sets: 3\n"+"Reps: 12-15\n" +"Tips: Sit on a bench with your legs spread. Rest your elbow on the inside of your thigh and curl the dumbbell up, squeezing your bicep at the top.\n")
        text.add("Incline Dumbbell Curls\n"+"\n" +"Sets: 3\n"+"Reps: 10-12\n"+"Tips: Sit on an incline bench with your arms fully extended and perpendicular to the floor. Curl the dumbbells up while keeping your upper arms stationary.\n")
        text.add("Preacher Curls\n"+"\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Tips: Use a preacher bench if available. Curl the weight up while keeping your upper arms on the bench, focusing on isolating the biceps.")








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