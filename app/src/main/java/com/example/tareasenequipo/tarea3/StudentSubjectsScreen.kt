package com.example.tareasenequipo.tarea3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
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
fun StudentSubjectsScreen(
    studentId: Int,
    onSubjectClick: (index: Int) -> Unit,
    onLogout: () -> Unit,
) {
    val subjects = Tarea3Repository.getSubjectsForStudent(studentId)

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
                "Mis materias",
                color = cTexto,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
            )
        }

        if (subjects.isEmpty()) {
            Text(
                "Sin materias.",
                color = cError,
                fontSize = 15.sp,
                modifier = Modifier.padding(16.dp),
            )
            return
        }

        LazyColumn(Modifier.weight(1f)) {
            itemsIndexed(subjects, key = { _, s -> s.id }) { index, subject ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSubjectClick(index) }
                        .padding(16.dp),
                ) {
                    Text(
                        subject.name,
                        color = cTexto,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        "Toca: faltas y calif.",
                        color = cGris,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                }
                HorizontalDivider(color = cGris.copy(alpha = 0.25f))
            }
        }
    }
}
