import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ManageCitiesScreen(navController: NavController) {
    var text by remember {
       mutableStateOf("")
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


    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = "Gerenciar cidades",
                    style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                var text by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.White, RoundedCornerShape(32.dp))
                    ,
                    singleLine = true,
                    label = {
                        Text(text = "Qual o seu email?")
                    },
                    placeholder = {
                        Text(text = "Digite seu email")
                    },
                    shape = RoundedCornerShape(32.dp),

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
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ){
                Column {
                    Row {
                        Text(
                            text = "São paulo",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium),
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }

                    Row {
                        Text(
                            text = "sensação térmica",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                }

                Row {
                    Text(
                        text = "21°",
                        style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Medium),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }

}

