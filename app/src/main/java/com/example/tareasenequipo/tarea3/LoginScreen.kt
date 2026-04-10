package com.example.tareasenequipo.tarea3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: (name: String, id: Int, role: UserRole) -> Unit,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var idText by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cFondo),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Acceso",
                color = cTexto,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Nombre y matrícula",
                color = cGris,
                fontSize = 15.sp,
            )
            Spacer(Modifier.height(20.dp))

            Text("Nombre", color = cGris, fontSize = 13.sp, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(4.dp))
            BasicTextField(
                value = name,
                onValueChange = { texto ->
                    name = texto
                    error = null
                },
                textStyle = TextStyle(fontSize = 16.sp, color = cOscuro),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(6.dp))
                    .border(1.dp, cGris, RoundedCornerShape(6.dp))
                    .padding(12.dp),
                maxLines = 1,
            )
            Spacer(Modifier.height(12.dp))

            Text("Matrícula (solo números)", color = cGris, fontSize = 13.sp, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(4.dp))
            BasicTextField(
                value = idText,
                onValueChange = { textoCompleto ->
                    // Solo dejamos pasar números, carácter por carácter.
                    var soloDigitos = ""
                    for (caracter in textoCompleto) {
                        if (caracter.isDigit()) {
                            soloDigitos = soloDigitos + caracter
                        }
                    }
                    idText = soloDigitos
                    error = null
                },
                textStyle = TextStyle(fontSize = 16.sp, color = cOscuro),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(6.dp))
                    .border(1.dp, cGris, RoundedCornerShape(6.dp))
                    .padding(12.dp),
                maxLines = 1,
            )

            if (error != null) {
                Spacer(Modifier.height(8.dp))
                Text(error!!, color = cError, fontSize = 13.sp)
            }
            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(cBarra, RoundedCornerShape(8.dp))
                    .clickable {
                        val nombreSinEspacios = name.trim()
                        if (nombreSinEspacios.isEmpty()) {
                            error = "Escribe tu nombre."
                            return@clickable
                        }
                        val matriculaNumero = LoginValidator.parseId(idText)
                        if (matriculaNumero == null) {
                            error = "Matrícula inválida."
                            return@clickable
                        }
                        val tipoUsuario = LoginValidator.validate(matriculaNumero)
                        if (tipoUsuario == null) {
                            error = "Coordinador 1–10 o alumno 20050–20200."
                            return@clickable
                        }
                        onLoginSuccess(nombreSinEspacios, matriculaNumero, tipoUsuario)
                    }
                    .padding(14.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text("Entrar", color = cTexto, fontSize = 17.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
