package com.example.testmvvm.extensions

import android.content.res.Resources


val Float.dp
    get() = this * Resources.getSystem().displayMetrics.density

val Int.dp
    get() = this * Resources.getSystem().displayMetrics.density.toInt()

val Double.dp
    get() = this * Resources.getSystem().displayMetrics.density.toDouble()

val Long.dp
    get() = this * Resources.getSystem().displayMetrics.density.toLong()
