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

class ShoulderWorkoutMEdia : AppCompatActivity() {
    private val videoUris: MutableList<Uri> = mutableListOf()
    private val text:MutableList<String> = mutableListOf()

    private var currentVideoIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shoulder_workout_media)

        val video: VideoView =findViewById(R.id.video)
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.overhead_barbell_press))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.dumbbell_lateral_raises))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.front_dumbbell_raises))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.seated_dumbbell_press))
        videoUris.add(Uri.parse("android.resource://" + packageName + "/" + R.raw.upright_rows))


        text.add("1. Overhead Barbell Press\n"+"Sets: 4\n"+"Reps: 8-12\n"+"Rest: 60-90 seconds\n"+"Instructions: Stand with your feet shoulder-width apart, grip the barbell slightly wider than shoulder-width, press the barbell overhead until your arms are fully extended, then lower it back to your shoulders.\n")
        text.add("2. Dumbbell Lateral Raises\n"+"Sets: 3\n"+"Reps: 12-15\n"+"Rest: 60 seconds\n"+"Instructions: Stand with a dumbbell in each hand at your sides, raise your arms out to the sides until they are parallel to the ground, then slowly lower them back down.\n")
        text.add("3. Front Dumbbell Raises\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Rest: 60 seconds\n"+"Instructions: Stand with a dumbbell in each hand, lift the dumbbells in front of you to shoulder height, then lower them back down. Keep your palms facing down throughout the movement.\n")
        text.add("4. Seated Dumbbell Press\n"+"Sets: 3\n"+"Reps: 8-12\n"+"Rest: 60-90 seconds\n"+"Instructions: Sit on a bench with a back support, hold a dumbbell in each hand at shoulder level with your palms facing forward, press the dumbbells overhead until your arms are fully extended, then lower them back down.\n")
        text.add("6. Upright Rows\n"+"Sets: 3\n"+"Reps: 10-12\n"+"Rest: 60 seconds\n"+"Instructions: Stand with your feet shoulder-width apart, hold a barbell with a close grip, lift the barbell straight up to your chin, keeping your elbows high, then lower it back down.\n")







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