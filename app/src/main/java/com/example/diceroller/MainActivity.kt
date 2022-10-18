package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the two dices to be used
        val dice = Dice(6)
        val dice2 = Dice(6)

        // Add a listener event to the "Roll" button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice(dice, dice2) }

        val thriceButton: Button = findViewById(R.id.button2)
        thriceButton.setOnClickListener {
            var maxRolled = 0
            for (i in 1..1000){
                var total: Int = rollDice(dice, dice2)

                if (total > maxRolled) {
                    maxRolled = total
                }
                val viewMaxRolled: TextView = findViewById(R.id.textView5)
                viewMaxRolled.text = maxRolled.toString()
            }
        }

        // Roll dice when app boots up
        rollDice(dice, dice2)
    }

    /**
     * All of the program happens here. This function imitates rolling a dice, and
     * ir includes all the logic so it is displayed on the app
     */
    private fun rollDice(dice: Dice, dice2: Dice): Int {

        // Creating the dice and getting the total
        val diceRoll1: Int = dice.roll()
        val diceRoll2: Int = dice2.roll()
        val total = diceRoll1 + diceRoll2

        // Modify the total based on the roll
        val textView: TextView = findViewById(R.id.textView2)
        textView.text = total.toString()

        // Adding some special text depending on the roll
        val specialText: TextView = findViewById(R.id.textView3)
        if (diceRoll1 == diceRoll2) {
            specialText.text = "Doubles!"
        } else {
            specialText.text = "Just a pair of dice"
        }

        // Find the imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Updating the image for the first die based on the dice roll
        when (diceRoll1) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        // Updating the image for the first die based on the dice roll
        when (diceRoll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }

        // Add a description to be read, if needed
        diceImage.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        return total
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