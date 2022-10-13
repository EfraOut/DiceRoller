package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add a listener event to the "Roll" button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Roll dice when app boots up
        rollDice()
    }

    private fun rollDice() {
        // Create a new 6-sized dice and roll it
        val dice = Dice(6)
        val diceRoll: Int = dice.roll()

        // Find the imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Updating the image based on the dice roll
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        // Add a description to be read, if needed
        diceImage.contentDescription(dice.roll()).toString()
    }
}

/**
 * Roll the dice and update the screen with the result
 */
class Dice(private val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}