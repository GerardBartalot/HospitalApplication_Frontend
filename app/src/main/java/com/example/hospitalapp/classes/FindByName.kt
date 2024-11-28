package com.example.hospitalapp.classes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hospitalapp.ui.theme.HospitalAppTheme
import com.example.hospitalapp.classes.CreateNurses
import com.example.hospitalapp.classes.Nurse
import com.example.hospitalapp.classes.NurseCard

// Pantalla de búsqueda de enfermero
@Composable
fun SearchScreen(createNurses: CreateNurses) {
    // Estado para el nombre del enfermero a buscar
    var query by remember { mutableStateOf("") }
    // Estado para el enfermero encontrado
    var foundNurse by remember { mutableStateOf<Nurse?>(null) }

    // Composable con el layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centra los elementos
    ) {
        // Campo de texto para ingresar el nombre del enfermero
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar enfermero por nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para realizar la búsqueda
        Button(
            onClick = {
                // Buscar el enfermero cuando se presiona el botón
                foundNurse = createNurses.nurses.find { it.name.contains(query, ignoreCase = true) }
            }
        ) {
            Text(text = "Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar la información del enfermero si se encuentra
        foundNurse?.let {
            NurseCard(nurse = it)
        }

        // Si no se encuentra enfermero, mostrar mensaje
        if (foundNurse == null && query.isNotEmpty()) {
            Text(text = "Enfermero no encontrado", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HospitalAppTheme {
                // Pasa la instancia de CreateNurses a SearchScreen
                SearchScreen(createNurses = CreateNurses())
            }
        }
    }
}

// Vista previa de la pantalla
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HospitalAppTheme {
        // Pasa la instancia de CreateNurses a SearchScreen
        SearchScreen(createNurses = CreateNurses())
    }
}
