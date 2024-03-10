package br.com.fiap.climasphere.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.clip

@Composable
fun HomeScreen() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
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
            Image(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "Icon Plus",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
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
                .background(color = Color.White.copy(alpha = 0.1f))
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment =  Alignment.CenterVertically

        ){
            Column {
                Text(
                    text = "21°",
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
                .background(color = Color.White.copy(alpha = 0.1f))
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
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Light),

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
    }
    }
}