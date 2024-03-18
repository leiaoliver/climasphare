package br.com.fiap.climasphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import br.com.fiap.climasphere.ui.theme.ClimaSphereTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.fiap.climasphere.screens.HomeScreen
import ManageCitiesScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.composable
import br.com.fiap.climasphere.screens.ConfigScreen
import br.com.fiap.climasphere.screens.NotificationScreen
import br.com.fiap.climasphere.screens.SplashScreen


val inter = FontFamily(
    Font(R.font.inter)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClimaSphereTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController, startDestination = "splash") {
                    composable("splash") {
                        SplashScreen(navController)
                    }
                    composable("home") {
                        HomeScreen(navController)
                    }
                    composable("manage_cities") {
                        ManageCitiesScreen(navController)
                    }
                    composable("configs") {
                        ConfigScreen(navController)
                    }
                    composable("notification") {
                        NotificationScreen(navController)
                    }

                }
            }
        }
    }
}


