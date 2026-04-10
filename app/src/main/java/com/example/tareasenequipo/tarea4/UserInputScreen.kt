package com.example.tareasenequipo.tarea4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun UserInputScreen(
    onContinue: (name: String, age: Int, wallet: Float) -> Unit,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var ageText by rememberSaveable { mutableStateOf("") }
    var walletText by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            "Datos del comprador",
            style = MaterialTheme.typography.titleLarge,
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it; error = null },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nombre") },
            singleLine = true,
        )
        OutlinedTextField(
            value = ageText,
            onValueChange = { if (it.all { c -> c.isDigit() }) ageText = it; error = null },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        OutlinedTextField(
            value = walletText,
            onValueChange = {
                val filtered = it.filter { c -> c.isDigit() || c == '.' || c == ',' }
                walletText = filtered
                error = null
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Dinero en monedero") },
            supportingText = { Text("Usa punto o coma para decimales") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
        )
        if (error != null) {
            Text(
                error!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
            )
        }
        Button(
            onClick = {
                val trimmed = name.trim()
                if (trimmed.isEmpty()) {
                    error = "Ingresa tu nombre."
                    return@Button
                }
                val age = ageText.toIntOrNull()
                if (age == null || age < 0) {
                    error = "Ingresa una edad válida."
                    return@Button
                }
                val normalized = walletText.replace(',', '.')
                val wallet = normalized.toFloatOrNull()
                if (wallet == null || wallet < 0f) {
                    error = "Ingresa un monto válido en el monedero."
                    return@Button
                }
                onContinue(trimmed, age, wallet)
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Ver videojuegos")
        }
    }
}
