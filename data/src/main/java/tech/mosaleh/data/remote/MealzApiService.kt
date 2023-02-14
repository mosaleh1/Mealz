package tech.mosaleh.data.remote

import retrofit2.http.GET
import tech.mosaleh.domain.entity.CategoryResponse

interface MealzApiService {

    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}