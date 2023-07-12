package com.example.calculator


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textViewDisplay: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewDisplay = findViewById(R.id.textViewDisplay)

//         Rest of your code for setting up the button click listeners


        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener { appendNumber("0") }

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { appendNumber("1") }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener { appendNumber("2") }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener { appendNumber("3") }

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener { appendNumber("4") }

        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener { appendNumber("5") }

        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener { appendNumber("6") }

        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener { appendNumber("7") }

        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener { appendNumber("8") }

        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener { appendNumber("9") }

        val buttonDot: Button = findViewById(R.id.buttonDot)
        buttonDot.setOnClickListener { appendNumber(".") }

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener { setOperator("+") }

        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        buttonSubtract.setOnClickListener { setOperator("-") }

        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        buttonMultiply.setOnClickListener { setOperator("*") }

        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        buttonDivide.setOnClickListener { setOperator("/") }

        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        buttonEquals.setOnClickListener { calculateResult() }

        val buttonAc : Button = findViewById(R.id.buttonAC)
        buttonAc.setOnClickListener { clear() }

        val buttonClear : Button = findViewById(R.id.buttonClear)
        buttonClear.setOnClickListener { clearChar() }

    }

    private fun appendNumber(number: String) {
        val currentText = textViewDisplay.text.toString()
        val newText = textViewDisplay.context.getString(R.string.number_placeholder, currentText + number)
        textViewDisplay.text = newText
    }

    private fun clear() {
        textViewDisplay.text = ""
        operand1 = 0.0
        operand2 = 0.0
        operator = null
    }

    private fun clearChar() {
        val currentText = textViewDisplay.text.toString()
        if (currentText.isNotEmpty()) {
            textViewDisplay.text = currentText.substring(0, currentText.length - 1)
        }
    }



    private fun setOperator(operator: String) {
        operand1 = textViewDisplay.text.toString().toDouble()
        textViewDisplay.text = operator
        this.operator = operator
    }

    private fun calculateResult() {
        if (operator != null) {
            operand2 = textViewDisplay.text.toString().toDouble()
            val result = when (operator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> {
                    if (operand2 != 0.0) {
                        operand1 / operand2
                    } else {
                        // Handle division by zero error
                        Double.NaN
                    }
                }
                else -> Double.NaN
            }

            textViewDisplay.text = result.toString()
        }
    }
}
