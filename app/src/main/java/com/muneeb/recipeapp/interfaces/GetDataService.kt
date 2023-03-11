package com.muneeb.recipeapp.interfaces

import retrofit2.Call
import com.muneeb.recipeapp.entities.Category
import retrofit2.http.GET

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>
}