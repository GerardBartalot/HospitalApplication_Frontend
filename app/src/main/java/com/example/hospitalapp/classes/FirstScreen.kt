package com.example.hospitalapp.classes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalapp.ui.theme.HospitalAppTheme


class FirstScreen {
    var nextScreen : String = "Home"

    @Composable
    fun HomeScreen() {
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                IndexButtons()
            }
        }
    }
    @Composable
    fun IndexButtons() {
        Column {
            Text(
                text = "Hospital Application",
                modifier = Modifier.fillMaxWidth().padding(16.dp, 0.dp),
                style = TextStyle(
                    textAlign = Center,
                    fontSize = 35.sp
                )

            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top
            ) {
                Button(onClick = {nextScreen="Login"}) {
                    Text(text = "Login", fontSize = 16.sp)
                }
                Button(onClick = {nextScreen="FindAll"}) {
                    Text(text = "FindAll", fontSize = 16.sp)
                }
                Button(onClick = {nextScreen="FindByName"}) {
                    Text(text = "FindByName", fontSize = 16.sp)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun HomeScreenPreview(){
        HospitalAppTheme{
            HomeScreen()
        }
    }


}