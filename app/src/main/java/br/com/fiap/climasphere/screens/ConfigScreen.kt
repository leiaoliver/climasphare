package br.com.fiap.climasphere.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigScreen(navController: NavController) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    var feedback by remember {
        mutableStateOf("")
    }

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Column(
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { "" },
                    modifier = Modifier
                        .offset(x = (-180).dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.seta_esquerda),
                        contentDescription = "Teste",
                        tint = Color.White,
                        modifier = Modifier
                            .height(35.dp)
                            .width(35.dp)
                    )
                }
                Text(
                    text = "Configurações",
                    fontSize = 22.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = inter,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                Text(
                    text = "Unidade de temperatura",
                    fontSize = 17.5.sp,
                    color = Color.White,
                    fontFamily = inter,
                )
                Text(
                    text = "ºC",
                    fontSize = 17.5.sp,
                    color = Color.White,
                    fontFamily = inter,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)

            ) {
                Text(
                    text = "Feedback",
                    fontSize = 17.5.sp,
                    color = Color.White,
                    fontFamily = inter,
                )
                IconButton(
                    onClick = { showDialog = true },
                    modifier = Modifier
                        .offset(x = 15.dp, y = 5.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.seta_direita),
                        contentDescription = "Teste",
                        tint = Color.White,
                        modifier = Modifier
                            .height(35.dp)
                            .width(35.dp)
                    )
                }
                if (showDialog) {
                    AlertDialog(
                        containerColor = Color.White,
                        onDismissRequest = { showDialog = false },
                        title = {
                            Text(
                                textAlign = TextAlign.Center,
                                text = "Feedback",
                                fontFamily = inter,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Black
                            )
                        },
                        text = {
                            val focusedIndicatorColor = 0xFF1A3546.toInt()

                            TextField(
                                colors = TextFieldDefaults.colors(
                                    focusedTextColor = Color.Black,
                                    focusedContainerColor = colorResource(id = R.color.white),
                                    unfocusedContainerColor = colorResource(id = R.color.white),
                                    focusedLabelColor = Color.Black,
                                    unfocusedLabelColor = Color.Black,
                                        focusedIndicatorColor = colorResource(id = R.color.purple_200)
                                ),
                                value = feedback,
                                onValueChange = { feedback = it },
                                placeholder = {
                                    Text(
                                        text = "Digite seu feedback aqui",
                                        fontFamily = inter,
                                        color = Color.Black
                                    )
                                }
                            )
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                    feedback = ""
                                },
                                colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200))
                            ) {
                                Text(
                                    text = "Enviar",
                                    fontFamily = inter,
                                    color = Color.White
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}