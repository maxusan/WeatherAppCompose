package com.banana.weatherAppCompose.domain.repository

import com.banana.weatherAppCompose.domain.util.Resource
import com.banana.weatherAppCompose.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}