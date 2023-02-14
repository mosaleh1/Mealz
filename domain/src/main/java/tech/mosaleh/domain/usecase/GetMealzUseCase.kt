package tech.mosaleh.domain.usecase

import tech.mosaleh.domain.repo.MealsRepo

class GetMealzUseCase (
    private val mealsRepo: MealsRepo
        ) {

     suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}