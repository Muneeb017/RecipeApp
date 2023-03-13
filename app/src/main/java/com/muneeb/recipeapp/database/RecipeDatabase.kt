package com.muneeb.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.muneeb.recipeapp.dao.RecipeDao
import com.muneeb.recipeapp.entities.Category
import com.muneeb.recipeapp.entities.CategoryItems
import com.muneeb.recipeapp.entities.Recipes
import com.muneeb.recipeapp.entities.converter.CategoryListConverter

@Database(entities = [Recipes::class, CategoryItems::class, Category::class], version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class)
abstract class RecipeDatabase : RoomDatabase() {

    companion object {

        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase != null) {
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