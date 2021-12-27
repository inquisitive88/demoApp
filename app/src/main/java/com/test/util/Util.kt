package com.test.util

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.util.Log
import com.google.gson.Gson



class Util(val context: Context) {
    var TAG = Util::class.java.name

    fun <T : Any> convertJsonToObject(json: String, classOnject: Class<T>): T {
        val gson = Gson()
        val classData = gson.fromJson(json, classOnject) as T
        return classData
    }

}