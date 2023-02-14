package tech.mosaleh.mealz.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.mosaleh.domain.repo.MealsRepo
import tech.mosaleh.domain.usecase.GetMealzUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase (repo: MealsRepo):GetMealzUseCase{
        return GetMealzUseCase(repo)
    }

}