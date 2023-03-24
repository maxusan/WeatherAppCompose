package com.banana.weatherAppCompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.banana.weatherAppCompose.domain.weather.WeatherData
import com.banana.weatherAppCompose.presentation.ui.theme.DarkBlue
import com.banana.weatherAppCompose.presentation.ui.theme.DeepBlue
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun DayWeatherItem(modifier: Modifier = Modifier, weatherData: List<WeatherData> = listOf()) {
    val minTemp = weatherData.minBy { it.temperatureCelsius }.temperatureCelsius.roundToInt()
    val maxTemp = weatherData.maxBy { it.temperatureCelsius }.temperatureCelsius.roundToInt()
    val middleWeatherData = weatherData[weatherData.size / 2]
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(64.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = DeepBlue,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = weatherData.first().time.format(DateTimeFormatter.ofPattern("dd/MM")),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(text = "$minTemp°C/$maxTemp°C", color = Color.White, fontWeight = FontWeight.Bold)
            Text(
                text = middleWeatherData.weatherType.weatherDesc,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
            Image(
                painter = painterResource(id = middleWeatherData.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.width(36.dp)
            )
        }
    }

}