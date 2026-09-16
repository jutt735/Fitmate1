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

class Triceps_Workout_MediaPlayer : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triceps_workout_media_player)
        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.close_grip_bench_press))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.overhead_dumbbell_tricep_extension))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.tricep_dips))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.skull_crushers))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.tricep_kickbacks))


        text.add("Close-Grip Bench Press\n"+"\n"+"Sets: 3\n"+"Reps: 8-12\n"+"Tips: Lie on a bench and grip the barbell with your hands shoulder-width apart. Lower the bar to your chest, keeping your elbows close to your body, and press it back up.\n")
        text.add("Overhead Dumbbell Tricep Extension\n"+"\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Tips: Hold a dumbbell with both hands and extend it over your head. Lower it behind your head by bending your elbows, then extend your arms back up.\n")
        text.add("Tricep Dips\n"+"\n"+"Sets: 3\n"+"Reps: 10-15\n"+"Tips: Use parallel bars or a bench. Lower your body by bending your elbows until your upper arms are parallel to the floor, then press back up.\n")
        text.add("Skull Crushers (Lying Tricep Extensions)\n"+"\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Tips: Lie on a bench holding a barbell or EZ curl bar. Lower the weight to your forehead by bending your elbows, then extend your arms back up.")
        text.add("Tricep Kickbacks\n"+"\n"+"Sets: 3\n"+"Reps: 12-15\n"+"Tips: Bend over at the waist with a flat back, and keep your upper arms close to your body. Extend the dumbbells back until your arms are fully extended, then return to the starting position.")








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