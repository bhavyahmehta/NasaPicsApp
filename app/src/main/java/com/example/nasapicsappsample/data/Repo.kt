package com.example.nasapicsappsample.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor() {
    suspend fun getItems(context: Context): List<Item> {
        kotlin.runCatching {
            val jsonString =
                context.assets.open("data.json").bufferedReader().use { it.readText() }
            if (jsonString.isNotEmpty()) {
                return Gson().fromJson(jsonString,
                    object : TypeToken<List<Item>>() {}.type)
            }
        }.getOrElse {
            emptyList<Item>()
        }
        return emptyList()
    }
}