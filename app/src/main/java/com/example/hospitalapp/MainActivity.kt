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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hospitalapp.ui.theme.HospitalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HospitalAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Lista de usuarios y contraseñas hardcodeados
val users = listOf(
    Pair("nurse1", "password1"),
    Pair("nurse2", "password2"),
    Pair("nurse3", "password3"),
    Pair("nurse4", "password4"),
    Pair("nurse5", "password5"),
    Pair("nurse6", "password6"),
    Pair("nurse7", "password7"),
    Pair("nurse8", "password8"),
    Pair("nurse9", "password9"),
    Pair("nurse10", "password10")
)

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginMessage by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Login de Enfermero",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Validar usuario y contraseña
                val isValid = users.any { user -> user.first == username && user.second == password }
                loginMessage = if (isValid) {
                    "Login exitoso"
                } else {
                    "Usuario o contraseña incorrectos"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = loginMessage,
            style = MaterialTheme.typography.bodyLarge,
            color = if (loginMessage == "Login exitoso") Color.Green else Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    HospitalAppTheme {
        LoginScreen()
    }
}
