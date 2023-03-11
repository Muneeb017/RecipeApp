package com.muneeb.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muneeb.recipeapp.entities.Category
import com.muneeb.recipeapp.entities.CategoryEntities
import com.muneeb.recipeapp.entities.Recipes

@Dao
interface RecipeDao {

    @Query("SELECT * FROM categoryentities ORDER BY id DESC")
    suspend fun getAllCategory(): List<CategoryEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryEntities?)

    @Query("DELETE FROM categoryentities")
    suspend fun clearDb()
}