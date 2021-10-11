package com.example.numberpopgame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.example.numberpopgame.databinding.GamePageBinding
import kotlin.random.Random
import kotlin.random.Random.Default.nextFloat


private lateinit var binding: GamePageBinding

class GamePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_page)
        binding = GamePageBinding.inflate(layoutInflater)
        val view = binding.root
        var currentNumber = 0
        binding.popup.text = currentNumber.toString()


        var dx = Random.nextFloat()
        var dy = Random.nextFloat()

        binding.popup.setOnClickListener {

            binding.popup.setX(dx)
            binding.popup.setY(dy)

        }

    }
}