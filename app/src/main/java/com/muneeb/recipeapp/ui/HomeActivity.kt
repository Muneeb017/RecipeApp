package com.muneeb.recipeapp.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.muneeb.recipeapp.adapter.MainCategoryAdapter
import com.muneeb.recipeapp.adapter.SubCategoryAdapter
import com.muneeb.recipeapp.database.RecipeDatabase
import com.muneeb.recipeapp.databinding.ActivityHomeBinding
import com.muneeb.recipeapp.entities.CategoryItems
import com.muneeb.recipeapp.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    lateinit var binding: ActivityHomeBinding

    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()

    lateinit var mainCategoryAdapter: MainCategoryAdapter
    lateinit var subCategoryAdapter: SubCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getDataFromDb()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


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

    private fun getDataFromDb() {
        launch {
            this.let {
                val cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                rvMainCategory.layoutManager =
                    LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                rvMainCategory.adapter = mainCategoryAdapter
            }
        }
    }

}
