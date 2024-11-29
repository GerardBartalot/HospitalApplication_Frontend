package com.example.hospitalapp.classes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
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
fun LoginScreen(modifier: Modifier = Modifier, onBackPressed: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginMessage by remember { mutableStateOf("") }
    var loginMessageColor by remember { mutableStateOf(Color.Transparent) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        // Contenido principal de la pantalla
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter // Mover todo el contenido hacia la parte superior
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(top = 16.dp) // Ajuste para acomodar la barra superior
            ) {
                Text(
                    text = "Login",
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Button(onClick = {
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

                // Button to go back to main menu
                Button(onClick = onBackPressed) {
                    Text(text = "Back")
                }

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
}
