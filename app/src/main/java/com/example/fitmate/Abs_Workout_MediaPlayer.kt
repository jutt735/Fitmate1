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

class Abs_Workout_MediaPlayer : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_abs_workout_media_player)
        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.plank))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.bicycle_crunches))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.leg_raises))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.russian_twists))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.mountain_climbers))


        text.add("Plank\n"+"\n"+"Sets: 3\n"+"Duration: 30-60 seconds\n"+"Tips: Keep your body in a straight line from head to heels. Engage your core and avoid letting your hips sag.\n")
        text.add("Bicycle Crunches\n"+"\n"+"Sets: 3\n"+"Reps: 20-30 (each side)\n"+"Tips: Lie on your back with hands behind your head. Bring your opposite elbow to your knee while extending the other leg, then switch sides in a pedaling motion.\n")
        text.add("Leg Raises\n"+"\n"+"Sets: 3\n"+"Reps: 15-20\n"+"Tips: Lie on your back with hands under your glutes. Lift your legs to a 90-degree angle and slowly lower them without touching the ground.\n")
        text.add("Russian Twists\n"+"\n"+ "Sets: 3\n"+"Reps: 20-30 (each side)\n"+"Tips: Sit with your knees bent and lean back slightly. Twist your torso to move your hands or a weight from side to side.\n")
        text.add("Mountain Climbers\n"+"\n"+"Sets: 3\n"+"Duration: 30-60 seconds\n"+"Tips: Start in a plank position. Bring one knee toward your chest, then quickly switch legs in a running motion.")




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