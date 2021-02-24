package com.appswithlove.coinpose.ui.core

import java.text.DecimalFormat

object Formatter {

    val dec = DecimalFormat("#,##0.00")

    fun price(value: Double): String = "$" + dec.format(value)

    fun percent(value: Double): String = dec.format(value) + "%"
}