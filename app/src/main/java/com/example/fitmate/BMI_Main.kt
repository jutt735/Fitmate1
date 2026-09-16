package com.example.fitmate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class BMI_Main: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_main)

        val ageEditText: EditText = findViewById(R.id.editText1)
        val heightEditText: EditText = findViewById(R.id.editText2)
        val weightEditText: EditText = findViewById(R.id.editText3)
        val MaleRadio: RadioButton = findViewById(R.id.radioButton1)
        val FemaleRadio: RadioButton = findViewById(R.id.radioButton2)
        val CalculateButton: Button = findViewById(R.id.button)
        val text1: TextView = findViewById(R.id.textView13)
        val text2: TextView = findViewById(R.id.textView)

        CalculateButton.setOnClickListener {
            val age = ageEditText.text.toString().toIntOrNull()
            val height = heightEditText.text.toString().toFloatOrNull()
            val weight = weightEditText.text.toString().toFloatOrNull()

            if (age == null || height == null || weight == null) {
                Toast.makeText(this, "Please fill all fields with valid values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = if (MaleRadio.isChecked) "male" else "female"
            val heightInMeters = height / 100.0
            val bmi = weight / (heightInMeters * heightInMeters)
            val formattedBmi = String.format("%.2f", bmi)
            Toast.makeText(this, formattedBmi, Toast.LENGTH_SHORT).show()

            var result = ""
            var message = ""

            if (gender == "male") {
                when {
                    bmi <= 18.4 -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Underweight"
                    }
                    bmi <= 24.9 -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Normal"
                    }
                    bmi <= 39.9 -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Overweight"
                    }
                    else -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Obese"
                    }
                }
            } else {
                when {
                    bmi <= 16.4 -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Underweight"
                    }
                    bmi <= 22.9 -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Normal"
                    }
                    bmi <= 36.9 -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Overweight"
                    }
                    else -> {
                        result = "Your BMI is: $formattedBmi"
                        message = "Obese"
                    }
                }
            }

            text1.text = result
            text2.text = message
            text1.visibility = View.VISIBLE
            text2.visibility = View.VISIBLE
        }
    }
}
