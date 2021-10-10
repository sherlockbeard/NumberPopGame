package com.example.numberpopgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberpopgame.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.StartButton.setOnClickListener {
            val intent = Intent(this, GamePage::class.java)
            startActivity(intent)
        }
        setContentView(view)
    }
}