package com.example.lasalleapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

data class Payment(
    val mes: String,
    val estado: String,
    val icono: ImageVector
)

val pagosPendientes = listOf(
    Payment("Febrero", "pendiente", Icons.Default.Warning),
    Payment("Abril", "pendiente", Icons.Default.Warning)
)


val pagosRealizados = listOf(
    Payment("Enero", "pagado", Icons.Default.Check),
    Payment("Marzo", "pagado", Icons.Default.Check),
    Payment("Mayo", "pagado", Icons.Default.Check)
)