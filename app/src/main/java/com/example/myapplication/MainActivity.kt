package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val nim = "245150700111001"
    val nama = "Jyesthaka Nabeel Anindya Virendra"

    NavHost(
        navController = navController,
        startDestination = "screen1"
    ) {
        composable("screen1") {
            Screen1(
                nim = nim,
                nama = nama,
                onNavigate = {
                    navController.navigate("screen2")
                }
            )
        }

        composable("screen2") {
            Screen2(
                nim = nim,
                nama = nama
            )
        }
    }
}

@Composable
fun Screen1(
    nim: String,
    nama: String,
    onNavigate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "NIM: $nim")
        Text(text = "Nama: $nama")
        Text(text = "Screen 1")

        Button(onClick = onNavigate) {
            Text("Ke Halaman 2")
        }
    }
}

@Composable
fun Screen2(
    nim: String,
    nama: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "NIM: $nim")
        Text(text = "Nama: $nama")
        Text(text = "Screen 2")
    }
}