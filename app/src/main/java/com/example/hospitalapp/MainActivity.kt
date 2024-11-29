package com.example.hospitalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalapp.classes.CreateNurses
import com.example.hospitalapp.classes.LoginScreen
import com.example.hospitalapp.classes.NurseApp
import com.example.hospitalapp.classes.SearchScreen
import com.example.hospitalapp.ui.theme.HospitalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HospitalAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("Home") }

    Surface(modifier = Modifier.fillMaxSize()) {
        when (currentScreen) {
            "Home" -> HomeScreen(onNavigate = { currentScreen = it })
            "Login" -> LoginScreen(modifier = Modifier.fillMaxSize(), onBackPressed = { currentScreen = "Home" })
            "GetAll" -> NurseApp(viewModel = CreateNurses(), onBackPressed = { currentScreen = "Home" })
            "FindByName" -> SearchScreen(createNurses = CreateNurses(), onBackPressed = { currentScreen = "Home" })
        }
    }
}

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hospital Application",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onNavigate("Login") }) {
                Text(text = "Login", fontSize = 16.sp)
            }
            Button(onClick = { onNavigate("GetAll") }) {
                Text(text = "GetAll", fontSize = 16.sp)
            }
            Button(onClick = { onNavigate("FindByName") }) {
                Text(text = "FindByName", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HospitalAppTheme {
        MainScreen()
    }
}

