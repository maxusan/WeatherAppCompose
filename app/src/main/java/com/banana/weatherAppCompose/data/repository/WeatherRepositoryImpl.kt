package com.banana.weatherAppCompose.data.repository

import com.banana.weatherAppCompose.data.mappers.toWeatherInfo
import com.banana.weatherAppCompose.data.remote.WeatherApi
import com.banana.weatherAppCompose.domain.repository.WeatherRepository
import com.banana.weatherAppCompose.domain.util.Resource
import com.banana.weatherAppCompose.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occured.")
        }
    }
}