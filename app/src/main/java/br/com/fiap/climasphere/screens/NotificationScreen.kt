package br.com.fiap.climasphere.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.climasphere.R
import br.com.fiap.climasphere.inter

@Composable
fun NotificationScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo ClimaSphere",
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Você deseja ativar as notificações?",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Black,
                lineHeight = 27.sp,
                modifier = Modifier
                    .width(290.dp)
            )
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.main_notification),
                    contentDescription = "Logo ClimaSphere",
                    modifier = Modifier
                        .width(390.dp)
                        .height(380.dp)
                )
                Row (
                    modifier = Modifier
                        .background(Color.White)
                        .padding(20.dp)
                        .width(300.dp)
                        .height(50.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo ClimaSphere",
                        modifier = Modifier
                            .width(60.dp)
                            .height(50.dp)
                    )
                }
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(11.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1A3546)),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Vamos começar",
                    fontSize = 16.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(11.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier
                    .width(130.dp)
                    .height(40.dp)
            ) {
                Text(
                    text = "Agora não",
                    fontSize = 16.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}