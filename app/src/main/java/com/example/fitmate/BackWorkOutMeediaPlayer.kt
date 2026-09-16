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

class BackWorkOutMeediaPlayer : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_back_work_out_meedia_player)

        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.pull_ups))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.bent_over_barbell_rows))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.one_arm_dumbbell_rows))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.seated_cable_rows))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.lat_pulldowns))


        text.add("Back Workout Routine\n"+"1. Pull-Ups\n"+"Sets: 4\n"+"Reps: 6-10\n"+"Rest: 60-90 seconds\n"+"Instructions: Grip the pull-up bar with your palms facing away from you, slightly wider than shoulder-width apart. Pull yourself up until your chin is above the bar, then lower back down.\n")
        text.add("2. Bent-Over Barbell Rows\n"+"Sets: 3\n"+"Reps: 8-12\n"+"Rest: 60-90 seconds\n"+"Instructions: Bend at your hips and knees, keep your back straight, and grip the barbell with your hands slightly wider than shoulder-width apart. Pull the barbell to your lower chest, then lower it back down.\n")
        text.add("3. One-Arm Dumbbell Rows\n"+"Sets: 3\n"+"Reps: 10-12 per arm\n"+"Rest: 60 seconds\n"+"Instructions: Place one knee and one hand on a bench for support, keep your back flat, and hold a dumbbell in the other hand. Pull the dumbbell towards your hip, then lower it back down.\n")
        text.add("4. Seated Cable Rows\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Rest: 60 seconds\n"+"Instructions: Sit at a cable row machine with your feet on the footrests, grasp the handle with both hands, and pull it towards your abdomen, squeezing your shoulder blades together. Slowly return to the starting position.\n")
        text.add("5. Lat Pulldowns\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Rest: 60 seconds\n"+"Instructions: Sit at the lat pulldown machine, grip the bar with your hands wider than shoulder-width apart, and pull it down to your chest. Slowly release it back up.\n")








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