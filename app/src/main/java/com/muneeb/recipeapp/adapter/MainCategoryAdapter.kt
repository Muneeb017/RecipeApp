package com.muneeb.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muneeb.recipeapp.R
import com.muneeb.recipeapp.entities.CategoryItems
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import kotlinx.android.synthetic.main.item_rv_sub_category.view.*

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var arrMainCategory = ArrayList<CategoryItems>()
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    fun setData(arrData: List<CategoryItems>) {
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_main_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = arrMainCategory[position]

        holder.itemView.tvDishName.text = model.strCategory

        Glide.with(holder.itemView.context).load(model.strCategoryThumb).into(holder.itemView.imgDish)
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size

    }

}
