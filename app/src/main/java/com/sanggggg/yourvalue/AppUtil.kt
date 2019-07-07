package com.sanggggg.yourvalue

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

fun compareDate(date : String) : Boolean {
    return getToday() == date
}

fun getToday() : String {
    //return SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().time)
    return "20190607"
}

fun getWeight(data : String) : Double = data.substring(0, data.length - 2).toDouble()

fun getFormattedWon(data : Double) : String = NumberFormat.getNumberInstance(Locale.US).format(data.toInt()) + "원"

fun getFormattedDate(data : String) : String {
    val year = data.substring(0, 4).toInt().toString()
    val month = data.substring(4, 6).toInt().toString()
    val day = data.substring(6, 8).toInt().toString()
    return year + "년 " + month + "월 " + day + "일"
}