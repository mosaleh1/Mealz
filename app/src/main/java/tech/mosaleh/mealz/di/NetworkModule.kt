package tech.mosaleh.mealz.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import tech.mosaleh.data.remote.MealzApiService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //todo provide http client
    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .callTimeout(20,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .build()
    }

    //todo provide retrofit client
    @Provides
    @Singleton
    fun provideRetrofit (
        okHttpClient: OkHttpClient
    ):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //todo provide api service impl
    @Provides
    @Singleton
    fun provideMealsApiService(
        retrofit: Retrofit
    ): MealzApiService {
        return retrofit.create(MealzApiService::class.java)
    }

}