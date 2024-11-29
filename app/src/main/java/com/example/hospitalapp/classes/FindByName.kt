package com.example.hospitalapp.classes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(createNurses: CreateNurses, onBackPressed: () -> Unit) {
    var query by remember { mutableStateOf("") }
    var foundNurse by remember { mutableStateOf<Nurse?>(null) }
    var isSearchPerformed by remember { mutableStateOf(false) } // Nuevo estado para rastrear si se realizó la búsqueda

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón "Back" en la parte superior izquierda
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 30.dp), // Alineado con el margen izquierdo de los demás elementos
            contentAlignment = Alignment.TopStart
        ) {
            Button(onClick = onBackPressed) {
                Text(text = "Back")
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar enfermero por nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            isSearchPerformed = true // Indicar que se realizó la búsqueda
            foundNurse = createNurses.nurses.find { it.name.contains(query, ignoreCase = true) }
        }) {
            Text(text = "Buscar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        foundNurse?.let {
            NurseCard(nurse = it)
        } ?: run {
            if (isSearchPerformed && query.isNotEmpty()) { // Mostrar el mensaje solo si se realizó la búsqueda
                Text(
                    text = "Enfermero no encontrado",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
