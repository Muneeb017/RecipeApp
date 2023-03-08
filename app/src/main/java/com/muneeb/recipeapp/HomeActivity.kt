package com.muneeb.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muneeb.recipeapp.adapter.MainCategoryAdapter
import com.muneeb.recipeapp.adapter.SubCategoryAdapter
import com.muneeb.recipeapp.databinding.ActivityHomeBinding
import com.muneeb.recipeapp.databinding.ItemRvSubCategoryBinding
import com.muneeb.recipeapp.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()

    lateinit var mainCategoryAdapter: MainCategoryAdapter
    lateinit var subCategoryAdapter: SubCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMainCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val arrMainCategory = arrayListOf<Recipes>()

        arrMainCategory.add(Recipes(1, "Beef"))
        arrMainCategory.add(Recipes(2, "Chicken"))
        arrMainCategory.add(Recipes(3, "Dessert"))
        arrMainCategory.add(Recipes(4, "Lamb"))

        val mainCategoryAdapter = MainCategoryAdapter(arrMainCategory)
        binding.rvMainCategory.adapter = mainCategoryAdapter

        binding.rvSubCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val arrSubCategory = arrayListOf<Recipes>()

        arrSubCategory.add(Recipes(1, "Beef and mustard pie"))
        arrSubCategory.add(Recipes(2, "Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipes(3, "Banana pancakes"))
        arrSubCategory.add(Recipes(4, "kapsalon"))

        val subCategoryAdapter = SubCategoryAdapter(arrSubCategory)
        binding.rvSubCategory.adapter = subCategoryAdapter

    }
}
