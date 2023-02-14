package tech.mosaleh.mealz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.mosaleh.domain.entity.CategoryResponse
import tech.mosaleh.domain.usecase.GetMealzUseCase
import javax.inject.Inject

@HiltViewModel
class MealsViewModel
    @Inject constructor(
    private val getMealsUseCase: GetMealzUseCase
) : ViewModel() {

    private val _categories : MutableStateFlow<CategoryResponse?> =
        MutableStateFlow(null)
    val categories : StateFlow<CategoryResponse?> = _categories

    fun getMealz(){
        viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
            }catch (e: Exception){
                Log.d("Mealz", "getMealz: $e")
            }
        }
    }

}