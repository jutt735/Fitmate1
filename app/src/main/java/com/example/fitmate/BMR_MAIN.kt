package com.example.fitmate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class BMR_MAIN : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val ageEditText: EditText = findViewById(R.id.EditText6)
        val weightEditText: EditText = findViewById(R.id.EditText8)
        val heightEditText: EditText = findViewById(R.id.EditText7)
        val maleRadio: RadioButton = findViewById(R.id.radioButton2)
        val femaleRadio: RadioButton = findViewById(R.id.radioButton4)
        val calculateButton: Button = findViewById(R.id.button2)
        val resultTextView: TextView = findViewById(R.id.textView14)

        calculateButton.setOnClickListener {
            val age = ageEditText.text.toString().toIntOrNull()
            val weight = weightEditText.text.toString().toFloatOrNull()
            val height = heightEditText.text.toString().toFloatOrNull()

            if (age == null || weight == null || height == null) {
                Toast.makeText(this, "Please fill all fields with valid values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmr: Double = if (maleRadio.isChecked) {
                88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
            } else {
                447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
            }

            val formattedBMR = String.format("%.2f", bmr)
            resultTextView.text = "Your BMR is: $formattedBMR calories per day"
        }
    }
}
