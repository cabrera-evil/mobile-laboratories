package com.evildev.laboratorio_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionCalculate: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Calling functions
        binding()
        setListeners()
    }

    private fun binding() {
        // Data input
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        // Calculate Button
        actionCalculate = findViewById(R.id.action_calculate)
        // Output
        bmiTextView = findViewById(R.id.bmi_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)
    }

    private fun setListeners() {
        actionCalculate.setOnClickListener {
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            // If the data input is empty, clear the output result and show a message
            if (!validateFields(weight, height)) {
                clearResult()
                return@setOnClickListener
            }

            // Clear focused item
            weightEditText.clearFocus()
            heightEditText.clearFocus()

            // Calculate BMI
            val bmi = calculateBmi(weight.toFloat(), height.toFloat())
            val bmiRound = String.format("%.2f", bmi).toFloat()
            // Display only two decimals on output
            displayResult(bmiRound)
        }
    }

    // Return the calculated BMI by the defined formula
    private fun calculateBmi(weight: Float, height: Float): Float =
        weight / ((height / 100) * (height / 100))

    private fun validateFields(weight: String?, height: String?): Boolean {
        // Show a warning message when any input is empty
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> true
        }
    }

    private fun displayResult(bmi: Float) {
        bmiTextView.text = bmi.toString()
        infoTextView.text = getString(R.string.normal_weight_info)

        var bmiResult = ""
        var color = 0

        // Show a different color and message depending of the result
        when {
            bmi < 18.50 -> {
                bmiResult = getString(R.string.under_weight_label)
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 -> {
                bmiResult = getString(R.string.healthy_label)
                color = R.color.normal_weight
            }
            bmi in 25.00..29.99 -> {
                bmiResult = getString(R.string.over_weight_label)
                color = R.color.over_weight
            }
            bmi > 29.99 -> {
                bmiResult = getString(R.string.obese_label)
                color = R.color.obese
            }
        }

        // Set a custom text color
        resultTextView.setTextColor(ContextCompat.getColor(this, color))
        // Show BMI result data
        resultTextView.text = bmiResult
    }

    private fun clearResult() {
        // Clear BMI result
        bmiTextView.text = ""
        resultTextView.text = ""
        infoTextView.text = ""
    }
}