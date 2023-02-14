package tech.mosaleh.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import tech.mosaleh.mealz.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel :MealsViewModel by viewModels()

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mAdapter : MealzAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // todo setUpRecyclerView
        mAdapter = MealzAdapter()
        mBinding.listCategories.adapter =  mAdapter

        viewModel.getMealz()

        observers()
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.categories.collect{
                it?.let { categoryResponse ->
                    mAdapter.submitList(categoryResponse.categories)
                }
            }
        }
    }
}