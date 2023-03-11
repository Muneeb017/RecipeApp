package com.muneeb.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithme.recipeapp.database.RecipeDatabase
import com.muneeb.recipeapp.adapter.MainCategoryAdapter
import com.muneeb.recipeapp.adapter.SubCategoryAdapter
import com.muneeb.recipeapp.databinding.ActivityHomeBinding
import com.muneeb.recipeapp.databinding.ItemRvSubCategoryBinding
import com.muneeb.recipeapp.entities.CategoryEntities
import com.muneeb.recipeapp.entities.Recipes
import com.muneeb.recipeapp.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    lateinit var binding: ActivityHomeBinding

    var arrMainCategory = ArrayList<CategoryEntities>()
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
                arrMainCategory = cat as ArrayList<CategoryEntities>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                rvMainCategory.layoutManager =
                    LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                rvMainCategory.adapter = mainCategoryAdapter
            }
        }
    }

}
