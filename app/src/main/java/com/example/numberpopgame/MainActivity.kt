package com.example.numberpopgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.example.numberpopgame.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
var currentNumber = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.StartButton.setOnClickListener {

            binding.StartPageText.visibility = View.GONE

            binding.StartButton.visibility = View.GONE


            GameStart()
            // val intent = Intent(this, GamePage::class.java)
            // startActivity(intent)


        }
        setContentView(view)
    }

    private fun GameStart() {
        var view = LayoutInflater.from(this).inflate(R.layout.popuplayout, null)
        var numberText = view.findViewById<TextView>(R.id.popup)
        numberText.text = currentNumber.toString()
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val popupWindow = PopupWindow(view, width, height, true)

        popupWindow.isOutsideTouchable = false
        popupWindow.isTouchable = true
        popupWindow.isFocusable = false

        popupWindow.showAtLocation(view, Gravity.BOTTOM, 100, 10 + 1) // dismiss the popup window when touched

        // dismiss the popup window when touched
        view.setOnTouchListener { v, event ->
            currentNumber++
            popupWindow.dismiss()
            GameStart()
            true
        }
    }
}