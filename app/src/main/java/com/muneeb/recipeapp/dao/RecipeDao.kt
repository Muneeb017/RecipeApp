package com.muneeb.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muneeb.recipeapp.entities.Category
import com.muneeb.recipeapp.entities.CategoryItems

@Dao
interface RecipeDao {

    @Query("SELECT * FROM categoryItems ORDER BY id DESC")
    suspend fun getAllCategory(): List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: CategoryItems)

    @Query("DELETE FROM categoryItems")
    suspend fun clearDb()
}