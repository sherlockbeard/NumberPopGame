package com.example.numberpopgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberpopgame.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.StartButton.setOnClickListener {  }
        setContentView(view)
    }
}