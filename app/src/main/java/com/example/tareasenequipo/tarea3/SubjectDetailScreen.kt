package com.example.tareasenequipo.tarea3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
fun SubjectDetailScreen(
    studentId: Int,
    subjectIndex: Int,
    onBack: () -> Unit,
) {
    val subject = Tarea3Repository.getSubject(studentId, subjectIndex)

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
                "Materia",
                color = cTexto,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        if (subject == null) {
            Text(
                "No existe.",
                color = cError,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp),
            )
            return
        }

        Column(Modifier.padding(24.dp)) {
            Text(
                subject.name,
                color = cTexto,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.height(12.dp))
            Text("Faltas", color = cEtiqueta, fontSize = 14.sp)
            Text(
                "${subject.absences}",
                color = cTexto,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.height(12.dp))
            Text("Calificación", color = cEtiqueta, fontSize = 14.sp)
            Text(
                String.format("%.1f", subject.grade),
                color = cTexto,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
