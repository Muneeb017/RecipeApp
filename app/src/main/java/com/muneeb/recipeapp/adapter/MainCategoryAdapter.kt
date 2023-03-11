package com.muneeb.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.muneeb.recipeapp.databinding.ItemRvMainCategoryBinding
import com.muneeb.recipeapp.entities.CategoryEntities
import com.muneeb.recipeapp.entities.Recipes
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.tv_dish_name

class MainCategoryAdapter(var arrMainCategory: ArrayList<CategoryEntities>) :
    RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(val itembinding: ItemRvMainCategoryBinding) :
        RecyclerView.ViewHolder(itembinding.root)

    fun setData(arrData: List<CategoryEntities>) {
        arrMainCategory = arrData as ArrayList<CategoryEntities>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = arrMainCategory[position]

        holder.itembinding.tvDishName.text = model.strCategory

        Glide.with(holder.itemView.context).load(model.strCategoryThumb).into(holder.itemView.imgDish)

    }

    override fun getItemCount(): Int {
        return arrMainCategory.size

    }
}
