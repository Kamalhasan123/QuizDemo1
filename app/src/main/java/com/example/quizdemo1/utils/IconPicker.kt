package com.example.quizdemo1.utils

import com.example.quizdemo1.R

object IconPicker {
    val icons=
        arrayOf(R.drawable.mathematics,
        R.drawable.english,
        R.drawable.science,
        R.drawable.generalknowledge)
    var currentIcon=0
    fun  getIcon():Int{
        currentIcon=(currentIcon +1 ) % icons.size
        return icons[currentIcon]
    }
}