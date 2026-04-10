package com.example.tareasenequipo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import com.example.tareasenequipo.tarea4.Tarea4NavHost
import com.example.tareasenequipo.tarea3.Tarea3NavHost
import com.example.tareasenequipo.ui.theme.TareasenequipoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TareasenequipoTheme {
                Tarea3NavHost(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Tarea4Preview() {
    TareasenequipoTheme {
        Tarea3NavHost(modifier = Modifier.fillMaxSize())
    }
}