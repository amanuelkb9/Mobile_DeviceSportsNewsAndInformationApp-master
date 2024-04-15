package com.example.sportsnewsandinformationapp.model

import java.io.Serializable
import java.util.Date

data class Event(var name: String, var description: String, var date: Date) : Serializable
