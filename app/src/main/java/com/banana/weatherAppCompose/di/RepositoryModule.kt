package com.banana.weatherAppCompose.di

import com.banana.weatherAppCompose.data.location.DefaultLocationTracker
import com.banana.weatherAppCompose.data.repository.WeatherRepositoryImpl
import com.banana.weatherAppCompose.domain.location.LocationTracker
import com.banana.weatherAppCompose.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
       weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}