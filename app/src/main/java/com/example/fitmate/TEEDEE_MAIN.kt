package com.example.fitmate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class TEEDEE_MAIN : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teedee_main)

        // Initializing views
        val ageEditText: EditText = findViewById(R.id.EditText9)
        val weightEditText: EditText = findViewById(R.id.EditText10)
        val heightEditText: EditText = findViewById(R.id.EditText11)
        val activityLevelSpinner: Spinner = findViewById(R.id.spinner)
        val calculateButton: Button = findViewById(R.id.button3)
        val resultTextView: TextView = findViewById(R.id.textView15)

        // Set OnClickListener for the calculate button
        calculateButton.setOnClickListener {
            // Get input values
            val age = ageEditText.text.toString().toIntOrNull()
            val weight = weightEditText.text.toString().toFloatOrNull()
            val height = heightEditText.text.toString().toFloatOrNull()

            // Check for valid input values
            if (age == null || weight == null || height == null) {
                Toast.makeText(this, "Please fill all fields with valid values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Determine activity level multiplier based on selected activity level
            val activityLevelMultiplier: Double = when (activityLevelSpinner.selectedItemPosition) {
                0 -> 1.2 // Sedentary
                1 -> 1.375 // Lightly active
                2 -> 1.55 // Moderately active
                3 -> 1.725 // Very active
                else -> 1.9 // Extra active
            }

            // Calculate BMR
            val bmr: Float = calculateBMR(age, weight, height)

            // Calculate TDEE
            val tdee: Float = (bmr * activityLevelMultiplier).toFloat()

            // Format TDEE result
            val formattedTDEE = String.format("%.2f", tdee)

            // Display result
            resultTextView.text = "Your TDEE is: $formattedTDEE calories per day"
        }
    }

    // Function to calculate BMR
    private fun calculateBMR(age: Int, weight: Float, height: Float): Float {
        val bmr: Double = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
        return bmr.toFloat()
    }
}
