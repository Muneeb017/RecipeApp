package com.codingwithme.recipeapp.database

import android.content.Context
import android.icu.util.ULocale
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muneeb.recipeapp.dao.RecipeDao
import com.muneeb.recipeapp.entities.Category
import com.muneeb.recipeapp.entities.CategoryEntities
import com.muneeb.recipeapp.entities.Recipes
import com.muneeb.recipeapp.entities.converter.CategoryListConverter
import java.util.*

@Database(
    entities = [Recipes::class, Category::class, CategoryEntities::class, CategoryListConverter::class],
    version = 1,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {

    companion object {

        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase == null) {
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao(): RecipeDao
}