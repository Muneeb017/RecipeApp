package com.muneeb.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.muneeb.recipeapp.databinding.ItemRvMainCategoryBinding
import com.muneeb.recipeapp.databinding.ItemRvSubCategoryBinding
import com.muneeb.recipeapp.entities.Recipes
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.tv_dish_name

class SubCategoryAdapter(var arrSubCategory: ArrayList<Recipes>) :
    RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val itembinding: ItemRvSubCategoryBinding) :
        RecyclerView.ViewHolder(itembinding.root) {}

    fun setData(arrData: List<Recipes>) {
        arrSubCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            ItemRvSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = arrSubCategory[position]

        holder.itemView.tv_dish_name.text = model.dishName

    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }
}
