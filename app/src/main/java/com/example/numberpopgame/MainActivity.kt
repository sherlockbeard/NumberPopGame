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
import kotlin.random.Random
import android.util.DisplayMetrics





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

            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)

            var width = displayMetrics.widthPixels
            var height = displayMetrics.heightPixels


            GameStart(width, height)
            // val intent = Intent(this, GamePage::class.java)
            // startActivity(intent)


        }
        this.setContentView(view)
    }
    

    private fun GameStart(screenWidth: Int, screenHeight : Int) {
        var view = LayoutInflater.from(this).inflate(R.layout.popuplayout, null)
        var numberText = view.findViewById<TextView>(R.id.popup)
        numberText.text = currentNumber.toString()
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val popupWindow = PopupWindow(view, width, height, true)

        popupWindow.isOutsideTouchable = false
        popupWindow.isTouchable = true
        popupWindow.isFocusable = false
        val x = Random.nextInt(-(screenWidth - 10), screenWidth - 10)
        val y = Random.nextInt(-(screenHeight - 10), screenHeight - 10)

        popupWindow.showAtLocation(view, Gravity.TOP, x, y) // dismiss the popup window when touched

        // dismiss the popup window when touched
        view.setOnTouchListener { v, event ->
            currentNumber++
            popupWindow.dismiss()
            GameStart(screenWidth, screenHeight)
            true
        }
    }
}