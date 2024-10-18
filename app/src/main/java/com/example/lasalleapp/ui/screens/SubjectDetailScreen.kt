package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.lasalleapp.ui.utils.gradesList

@Composable
fun SubjectDetailScreen(subjectId: Int, innerPadding: PaddingValues) {
    val grades = gradesList.first { it.id == subjectId }
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Título de la materia
        Text(
            text = grades.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.W900
        )

        // Calificaciones de los parciales
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Parcial 1: ${grades.partial1}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Parcial 2: ${grades.partial2}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Parcial 3: ${grades.partial3}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Text(
            text = "Promedio Final: %.2f".format(grades.finalAverage),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}
