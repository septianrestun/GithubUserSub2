package com.dicoding.githubusersub2.`class`

import java.text.NumberFormat
import java.util.*

class IntegerHelper {
    companion object{
        fun readAbleInt(num: Int): String{
            return NumberFormat.getNumberInstance(Locale.US).format(num)
        }
    }
}