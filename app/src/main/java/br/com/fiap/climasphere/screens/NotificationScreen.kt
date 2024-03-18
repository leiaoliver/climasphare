package br.com.fiap.climasphere.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.climasphere.R
import br.com.fiap.climasphere.inter

@Composable
fun NotificationScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
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
            Image(
                painter = painterResource(id = R.drawable.main_notification),
                contentDescription = "Logo ClimaSphere",
                modifier = Modifier
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(10.dp)
                        .width(300.dp)
                        .height(20.dp)
                        .drawBehind {
                            drawRect(
                                color = Color.Gray,
                                size = Size(size.width, 1.dp.toPx()),
                                topLeft = Offset(0f, size.height - (-12.5).dp.toPx())
                            )
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.task),
                        tint = Color.White,
                        contentDescription = "Logo ClimaSphere",
                        modifier = Modifier
                            .height(30.dp)
                    )
                    Text(
                        text = "Planejamento diário",
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(10.dp)
                        .width(300.dp)
                        .height(20.dp)
                        .drawBehind {
                            drawRect(
                                color = Color.Gray,
                                size = Size(size.width, 1.dp.toPx()),
                                topLeft = Offset(0f, size.height - (-12.5).dp.toPx())
                            )
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.task),
                        tint = Color.White,
                        contentDescription = "Logo ClimaSphere",
                        modifier = Modifier
                            .height(30.dp)
                    )
                    Text(
                        text = "Previsões precisas",
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(10.dp)
                        .width(300.dp)
                        .height(20.dp)
                        .drawBehind {
                            drawRect(
                                color = Color.Gray,
                                size = Size(size.width, 1.dp.toPx()),
                                topLeft = Offset(0f, size.height - (-12.5).dp.toPx())
                            )
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.task),
                        tint = Color.White,
                        contentDescription = "Logo ClimaSphere",
                        modifier = Modifier
                            .height(30.dp)
                    )
                    Text(
                        text = "Notificações de chuva",
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(Color(R.color.purple_200)),
                    modifier = Modifier
                        .width(300.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Ativar Notificações",
                        fontSize = 16.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Button(
                    onClick = {navController.navigate("home")},
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .width(300.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Agora não",
                        fontSize = 13.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}