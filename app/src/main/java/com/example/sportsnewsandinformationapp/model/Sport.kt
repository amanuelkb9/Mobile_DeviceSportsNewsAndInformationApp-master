package com.example.sportsnewsandinformationapp.model

import android.content.Context
import com.example.sportsnewsandinformationapp.R
import java.io.Serializable

enum class SportType {
    MEASURE,
    PRECISION,
    SPECTACLE,
    COMBAT,
    PLAY;

    private lateinit var context: Context

    fun setContext(context: Context){
        this.context = context
    }

    fun getString(): String {
        val stringArray = context.resources.getStringArray(R.array.sport_type_values)
        val index = ordinal
        return if (index >= 0 && index < stringArray.size) {
            stringArray[index]
        } else {
            throw IndexOutOfBoundsException("Invalid enum index: $index")
        }
    }
}

data class Sport(val context:Context, val type: SportType, var name: String, var instruction: String) : Serializable {
    init {
        type.setContext(context)
    }
}
