package tech.mosaleh.mealz.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.mosaleh.data.remote.MealzApiService
import tech.mosaleh.data.repo.MealsRepoImpl
import tech.mosaleh.domain.repo.MealsRepo

@InstallIn(SingletonComponent::class)
@Module
object RepoModule {

    @Provides
    fun provideMealsRepo(apiService: MealzApiService):MealsRepo {
        return MealsRepoImpl(apiService)
    }
}