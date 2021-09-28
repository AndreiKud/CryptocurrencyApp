package ru.andreikud.cryptocurrencyapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    fun provideApi(): CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(CoinPaprikaApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)
}