package br.com.fiap.climasphere.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.climasphere.R
import br.com.fiap.climasphere.inter

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF265069))
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
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Bem vindo ao ClimaSphere",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Black,
                lineHeight = 35.sp,
                modifier = Modifier
                    .width(200.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "Previsões precisas, alertas de tempestade e dicas para se preparar.",
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                fontFamily = inter,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp,
                modifier = Modifier
                    .width(280.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.main_home),
                contentDescription = "Logo ClimaSphere",
                modifier = Modifier
                    .width(390.dp)
                    .height(380.dp)
            )
            Button(
                onClick = {navController.navigate("notification")},
                shape = RoundedCornerShape(11.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.dark_blue)),
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
        }
    }
}