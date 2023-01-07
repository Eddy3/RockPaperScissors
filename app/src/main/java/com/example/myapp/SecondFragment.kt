package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var playerChoice: Button
    private lateinit var computerChoice: TextView
    private lateinit var result: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerChoice = findViewById(R.id.player_choice)
        computerChoice = findViewById(R.id.computer_choice)
        result = findViewById(R.id.result)

        playerChoice.setOnClickListener {
            val player = (it as Button).text.toString()
            val computer = getComputerChoice()
            val winner = getWinner(player, computer)

            computerChoice.text = getString(R.string.computer_choice, computer)
            result.text = getString(R.string.result, winner)
    }
        
    }

    private fun findViewById(playerChoice: Int): Button {

    }

    fun getComputerChoice(): String {
        val random = Random.Default

        return when (random.nextInt(3)) {
            0 -> "rock"
            1 -> "paper"
            2 -> "scissors"
            else -> "Nope! Try again."
        }
    }

    fun getWinner(player: String, computer: String): String {
        if (player == computer) {
            return "It's a tie!"
        } else if (player == "rock" && computer == "scissors" ||
            player == "paper" && computer == "rock" ||
            player == "scissors" && computer == "paper"
        ) {
            return "Fair play! $player beats $computer"
        } else {
            return "Sorry! $computer beats $player"
        }
    }
}