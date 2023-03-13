package com.muneeb.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.muneeb.recipeapp.entities.Category
import kotlinx.android.parcel.TypeParceler

class CategoryListConverter {

    @TypeConverter
    fun fromCategoryList(category: List<Category>): String? {
        return if (category == null) {
            null
        } else {
            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            gson.toJson(category, type)
        }
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<Category>? {
        return if (categoryString == null) {
            null
        } else {
            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            gson.fromJson(categoryString, type)
        }
    }

}