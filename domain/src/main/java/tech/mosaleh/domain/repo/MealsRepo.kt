package tech.mosaleh.domain.repo

import tech.mosaleh.domain.entity.CategoryResponse

interface MealsRepo {
    suspend fun getMealsFromRemote():CategoryResponse
}