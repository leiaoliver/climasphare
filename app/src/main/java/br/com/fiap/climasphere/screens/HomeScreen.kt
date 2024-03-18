package br.com.fiap.climasphere.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.climasphere.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import androidx.compose.runtime.*
import com.google.gson.JsonParser
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element



@Composable
fun HomeScreen(navController: NavController) {

    var temperatureData by remember { mutableStateOf<Pair<Int, Int>?>(null) }

    LaunchedEffect(Unit) {
        temperatureData = fetchTemperature()
    }

    Box(
        contentAlignment = Alignment.TopStart,
    modifier = Modifier
        .background(Color(0xFF265069))
        .fillMaxSize()
        .padding(
            horizontal = 24.dp,
            vertical = 24.dp
        )


    ) {
    Column (

    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier
                    .clickable { navController.navigate("manage_cities") }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Icon Plus",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)

                )


            }

            Text(
                text = "São Paulo",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                color = Color.White
            )

            Box(
                modifier = Modifier
                    .clickable { navController.navigate("configs")
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.config),
                    contentDescription = "Icon Plus",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment =  Alignment.CenterVertically

        ){
            Column {
                temperatureData?.let { (minTemperature, maxTemperature) ->
                    Text(
                        text = "Mínima: $minTemperature°C | Máxima: $maxTemperature°C",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                } ?: Text(
                    text = "N/A",
                    style = TextStyle(fontSize = 50.sp, fontWeight = FontWeight.Bold),
                    color = Color.White
                )

                Text(
                    text = "Pancadas de chuva",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = R.drawable.rain),
                contentDescription = "Icon Plus",
                modifier = Modifier
                    .width(78.dp)
                    .height(70.dp)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment =  Alignment.CenterVertically

        ){
            Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.notice),
                    contentDescription = "Icon Plus",
                    modifier = Modifier
                        .width(15.dp)
                        .height(15.dp)

                )
                Text(
                    text = "Aviso",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Text(
                        text = "% CHUVA",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                        color = Color.White,

                    )
                    Text(
                        text = "EXP. TIME",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    Text(
                        text = "58%",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Light),
                        color = Color.White,
                    )
                    Text(
                        text = "02:00 PM",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Light),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Text(
                        text = "Esperando chuva",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light,
                            color = Color(0xFFFFD600)
                        )
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.rain_two),
                contentDescription = "Icon Plus",
                modifier = Modifier
                    .width(78.dp)
                    .height(70.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "UV",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Qualidade do Ar",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
                        color = Color.White,
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Tempo",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
                        color = Color.White,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "4",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                        color = Color.White,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Ruim",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                        color = Color(0xFFE21919),
                        modifier = Modifier.padding(start = 40.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "11:25 AM",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                        color = Color.White,
                        modifier = Modifier.padding(start = 40.dp)
                    )
                }
            }


        }
    }
    }
}


suspend fun fetchTemperature(): Pair<Int, Int>? {
    val token = "c7629c8095c32b502bb9efb0b9abbbc3"
    val localeId = "3477" // ID de São Paulo

    val client = OkHttpClient()

    val request = Request.Builder()
        .url("http://apiadvisor.climatempo.com.br/api/v1/weather/locale/$localeId/current?token=$token")
        .build()

    return try {
        val response = withContext(Dispatchers.IO) {
            client.newCall(request).execute()
        }

        val responseBody = response.body?.string()

        if (response.isSuccessful && !responseBody.isNullOrEmpty()) {
            val jsonData = JSONObject(responseBody)
            val temperatureData = jsonData.getJSONObject("data").getJSONObject("temperature")
            val minTemperature = temperatureData.getInt("min")
            val maxTemperature = temperatureData.getInt("max")
            Pair(minTemperature, maxTemperature)
        } else {
            Log.e("fetchTemperature", "Failed to fetch temperature. Response: $response")
            null
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

