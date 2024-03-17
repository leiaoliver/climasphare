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
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Console


@Composable
fun HomeScreen(navController: NavController) {

    var temperature by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            temperature = fetchTemperature()
            Log.i("TAG", "MeuComponente: $temperature")
        }
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

            Image(
                painter = painterResource(id = R.drawable.config),
                contentDescription = "Icon Plus",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
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
                Text(
                    text = temperature,
                    style = TextStyle(fontSize = 64.sp, fontWeight = FontWeight.Bold),
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

suspend fun fetchTemperature(): String {
    val username = "clima_oliveira_leia"
    val password = "IR5lkK5q40"
    val baseUrl = "https://api.meteomatics.com"
    val endpoint = "/2024-03-17T00:00:00Z/t_2m:C/52.520551,13.461804/html"

    val client = OkHttpClient()

    val request = Request.Builder()
        .url(baseUrl + endpoint)
        .header("Authorization", Credentials.basic(username, password))
        .build()

    return try {
        val response = withContext(Dispatchers.IO) {
            client.newCall(request).execute()
        }
        val responseBody = response.body?.string()

        // Processar a resposta aqui e extrair a temperatura

        responseBody ?: ""
    } catch (e: IOException) {
        e.printStackTrace()
        ""
    }
}
