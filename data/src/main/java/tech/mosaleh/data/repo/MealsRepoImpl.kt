package tech.mosaleh.data.repo

import tech.mosaleh.data.remote.MealzApiService
import tech.mosaleh.domain.entity.CategoryResponse
import tech.mosaleh.domain.repo.MealsRepo

class MealsRepoImpl (
    val mealsApi: MealzApiService
        ) : MealsRepo {

        override suspend fun getMealsFromRemote(): CategoryResponse {
               return mealsApi.getMeals()
        }
}