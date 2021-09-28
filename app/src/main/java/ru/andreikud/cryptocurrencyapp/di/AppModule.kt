package ru.andreikud.cryptocurrencyapp.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.andreikud.cryptocurrencyapp.data.remote.CoinPaprikaApi
import ru.andreikud.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import ru.andreikud.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor.Logger { msg ->
            Log.d("wow", "provideOkHttpClient: $msg")
        }
        val loggingInterceptor = HttpLoggingInterceptor(logger)
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): CoinPaprikaApi = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(CoinPaprikaApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)
}