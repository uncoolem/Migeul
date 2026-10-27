package com.example.tournament

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.tournament.data.Tournament
import com.example.tournament.screens.BasketScreen
import com.example.tournament.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedTournament by remember { mutableStateOf<Tournament?>(null) }

            if (selectedTournament == null) {
                HomeScreen(onJoinClick = { tournament ->
                    selectedTournament = tournament
                })
            } else {
                BasketScreen(
                    tournament = selectedTournament!!,
                    onBackClick = { selectedTournament = null }
                )
            }
        }
    }
}