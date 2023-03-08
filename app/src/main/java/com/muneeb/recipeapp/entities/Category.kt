package com.muneeb.recipeapp.entities

data class Category(

    val categories: List<CategoryEntities>

) {

    data class CategoryEntities(
        val idCategory: String,
        val strCategory: String,
        val strCategoryDescription: String,
        val strCategoryThumb: String
    )

}
