package com.example.tareasenequipo.tarea3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CoordinatorListScreen(
    onStudentClick: (studentId: Int) -> Unit,
    onLogout: () -> Unit,
) {
    val students = Tarea3Repository.allStudents()

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
            IconButton(onClick = onLogout) {
                Icon(Icons.Filled.Logout, null, tint = cTexto)
            }
            Text(
                "Lista de alumnos",
                color = cTexto,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            itemsIndexed(students, key = { _, alumno -> alumno.id }) { index, student ->
                val colorFila = if (index % 2 == 0) {
                    cFilaA
                } else {
                    cFilaB
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(colorFila)
                        .clickable { onStudentClick(student.id) }
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        "${index + 1}.",
                        fontSize = 14.sp,
                        color = Color(0xFF333333),
                        modifier = Modifier.padding(end = 8.dp),
                    )
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(cIcono),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            Icons.Filled.School,
                            null,
                            tint = cTexto,
                            modifier = Modifier.size(24.dp),
                        )
                    }
                    Spacer(Modifier.size(10.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            "${student.id} | ${student.name}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF222222),
                        )
                        Text(
                            student.email,
                            fontSize = 12.sp,
                            color = Color(0xFF555555),
                        )
                        Text(
                            student.degreeDescription,
                            fontSize = 11.sp,
                            color = Color(0xFF666666),
                            modifier = Modifier.padding(top = 4.dp),
                        )
                    }
                }
            }
        }
    }
}
