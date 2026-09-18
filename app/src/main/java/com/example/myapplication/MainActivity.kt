package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Activity1Screen {
                            textInput ->
                        val intent = Intent(this, Activity2::class.java)
                        intent.putExtra("text_input", textInput)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun Activity1Screen(onButtonClick: (String) -> Unit) {

    var textInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "NIM: 245150400111008")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Nama: Jyesthaka Nabeel Anindya Virendra")

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = {
                Text("Masukkan Text")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onButtonClick(textInput)
            }
        ) {
            Text("Kirim")
        }
    }
}