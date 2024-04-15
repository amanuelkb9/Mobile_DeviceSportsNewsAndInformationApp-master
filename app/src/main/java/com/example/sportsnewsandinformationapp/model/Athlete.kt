package com.example.sportsnewsandinformationapp.model

import java.io.Serializable

data class Athlete(
    var name: String,
    var sport: String,
    var country: String,
    var personalBest: String,
    var medalsAwarded: Int,
    var facts: String
) : Serializable
