package com.example.hospitalapp.classes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalapp.ui.theme.HospitalAppTheme


// Modelo de datos
data class Nurse(val id: Int, val name: String, val username: String)

// Clase para manejar los datos hardcodeados
class CreateNurses {
    val nurses = listOf(

        Nurse(1, "Nil Arroyo", "ni95_ar"),
        Nurse(2, "Gerard Bartalot", "GeryBar"),
        Nurse(3, "Joan Albert Chias", "Jachias"),
        Nurse(4, "Sergio Arenas", "sejuma"),

        )
}

@Composable
fun NurseApp(viewModel: CreateNurses) {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NurseList(nurses = viewModel.nurses)
        }
    }
}

@Composable
fun NurseList(nurses: List<Nurse>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(nurses) { nurse ->
            NurseCard(nurse)
        }
    }
}

@Composable
fun NurseCard(nurse: Nurse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${nurse.id}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "Name: ${nurse.name}", fontSize = 14.sp)
            Text(
                text = "Username: ${nurse.username}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NurseAppPreview() {
    HospitalAppTheme {
        NurseApp(viewModel = CreateNurses())
    }
}
