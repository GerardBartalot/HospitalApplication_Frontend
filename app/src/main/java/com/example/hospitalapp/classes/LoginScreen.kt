package com.example.hospitalapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    var loginMessageColor by remember { mutableStateOf(Color.Transparent) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter // Mover todo el contenido hacia la parte superior
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 32.dp) // Separar el título de los bordes superiores
        ) {
            // Encabezado decorativo para el título
            Text(
                text = "Login",
                color = Color.Black, // Cambiado a negro
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp)) // Espacio adicional debajo del título

            // Campo de texto para el nombre de usuario
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Campo de texto para la contraseña
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Botón de inicio de sesión
            Button(onClick = {
                // Lógica de validación del login
                if (users.any { it.first == username && it.second == password }) {
                    loginMessage = "Login exitoso"
                    loginMessageColor = Color.Green
                } else {
                    loginMessage = "Nombre de usuario o contraseña incorrectos"
                    loginMessageColor = Color.Red
                }
            }) {
                Text("Login")
            }

            // Mensaje de resultado del login
            if (loginMessage.isNotEmpty()) {
                Text(
                    text = loginMessage,
                    color = loginMessageColor,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
