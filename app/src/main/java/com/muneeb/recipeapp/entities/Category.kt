package com.muneeb.recipeapp.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.muneeb.recipeapp.entities.converter.CategoryListConverter
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Category")
@TypeConverters(CategoryListConverter::class)
data class Category(
    val categories: List<CategoryEntities>? = null
) : Parcelable

@Parcelize
@Entity(tableName = "CategoryEntities")
data class CategoryEntities(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
) : Parcelable
