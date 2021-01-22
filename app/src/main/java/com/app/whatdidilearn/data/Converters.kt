package com.app.whatdidilearn.data

import androidx.room.TypeConverter
import com.app.whatdidilearn.R
import com.app.whatdidilearn.entities.UnderstandingLevel

class Converters {
    @TypeConverter
    fun levelToInt (level: UnderstandingLevel): Int {
        return level.color
    }

    @TypeConverter
    fun intToLevel (color: Int): UnderstandingLevel {
        return when(color) {
            R.color.red -> UnderstandingLevel.LOW
            R.color.yellow -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }
}