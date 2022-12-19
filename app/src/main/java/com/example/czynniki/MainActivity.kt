package com.example.czynniki

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberEditText = findViewById<EditText>(R.id.text)
        val factorizeButton = findViewById<Button>(R.id.button)
        val resultTextView = findViewById<TextView>(R.id.wynik)

        factorizeButton.setOnClickListener(View.OnClickListener {
            val number = Integer.valueOf(numberEditText.text.toString())
            val factors = factorizeNumber(number)
            val factorString = factors.joinToString(separator = " x ")
            resultTextView.text = factorString
        })
    }

    private fun factorizeNumber(number: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var zmienna = 2
        var liczba = number

        while (liczba > 1) {
            if (liczba % zmienna == 0) {
                factors.add(zmienna)
                liczba /= zmienna
            } else {
                zmienna += 1
            }
        }
        return factors
    }

}