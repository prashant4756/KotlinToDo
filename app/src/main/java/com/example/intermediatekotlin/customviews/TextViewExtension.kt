package com.example.intermediatekotlin.customviews

import android.graphics.Paint
import android.widget.TextView

fun TextView.setStrikeThrough(){
    this.paintFlags =  paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun TextView.removeStrikeThrough(){
    this.paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}