package com.banana.weatherAppCompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banana.weatherAppCompose.presentation.ui.theme.DeepBlue

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = DeepBlue
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Today", fontSize = 20.sp, color = Color.White)
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(content = {
                        items(data) { weatherData ->
                            HourlyWeatherDisplay(
                                weatherData = weatherData,
                                modifier = Modifier
                                    .height(100.dp)
                                    .padding(horizontal = 8.dp)
                            )
                        }
                    })
                }
            }
            Divider(modifier = Modifier.padding(vertical = 4.dp))
            LazyColumn(content = {
                items(state.weatherInfo.weatherDataPerDay.values.toList()) { weatherData ->
                    DayWeatherItem(weatherData = weatherData, modifier = Modifier.fillMaxWidth())
                }
            })
        }
    }
}