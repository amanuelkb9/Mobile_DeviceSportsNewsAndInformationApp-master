package com.example.sportsnewsandinformationapp.model

import java.io.Serializable
import java.util.Date

data class HistoricalSportsArchive(var name: String, var dateOrDateRange: String, var description: String) :
    Serializable
