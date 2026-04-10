package com.example.tareasenequipo.tarea3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CoordinatorStudentDetailScreen(
    studentId: Int,
    onBack: () -> Unit,
) {
    val student = Tarea3Repository.getStudent(studentId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(cFondo),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(cBarra)
                .padding(vertical = 6.dp, horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null, tint = cTexto)
            }
            Text(
                "Detalle alumno",
                color = cTexto,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        if (student == null) {
            Text(
                "No está ese alumno.",
                color = cError,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp),
            )
            return
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        ) {
            Text(
                "${student.id} | ${student.name}",
                color = cTexto,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(student.email, color = cGris, fontSize = 15.sp)
            Text(student.degreeDescription, color = cGris, fontSize = 14.sp)
            Spacer(Modifier.height(8.dp))
            HorizontalDivider(color = cGris.copy(alpha = 0.35f))
            Spacer(Modifier.height(8.dp))

            Linea("Carrera", student.career)
            Linea("Pasatiempo", student.hobby)
            Linea("Promedio", String.format("%.1f", student.average))
            Spacer(Modifier.height(12.dp))

            Text(
                "Materias en curso",
                color = cTexto,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
            )
            for (i in student.currentSubjects.indices) {
                val nombreMateria = student.currentSubjects[i]
                Text(
                    "${i + 1}. $nombreMateria",
                    color = cGris,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(vertical = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun Linea(etiqueta: String, valor: String) {
    Column(Modifier.padding(vertical = 4.dp)) {
        Text(etiqueta, color = cEtiqueta, fontSize = 13.sp)
        Text(valor, color = cTexto, fontSize = 16.sp)
    }
}
