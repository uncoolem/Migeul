package com.example.tournament.data

data class Tournament(
    val id: String,
    val title: String,
    val format: String,
    val entryFee: String,
    val startTime: String,
    val gameIcon: String
)