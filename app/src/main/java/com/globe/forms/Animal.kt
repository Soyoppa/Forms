package com.globe.forms

import android.util.Log

open class Animal {

    open var numberOflegs:Int = 0

    fun walk(){
        Log.d("Animal","Animal with $numberOflegs legs")
    }
}