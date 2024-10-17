package com.example.lasalleapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lasalleapp.R
import com.example.lasalleapp.models.pagosPendientes
import com.example.lasalleapp.models.pagosRealizados
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ScreenTemplate
import com.example.lasalleapp.ui.utils.Logout

@Composable
fun PayScreen(innerPadding: PaddingValues) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo Image",
                modifier = Modifier.size(70.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Hola", color = Color.White, fontSize = 18.sp)
                Text(
                    text = stringResource(id = R.string.welcome_text),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 15.dp)
                )
            }

            Icon(
                imageVector = Logout,
                contentDescription = "logout",
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        Log.i("PayScreen", "Cerrando sesión")
                    },
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.payment_receipt),
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 150.dp),
            )
        }
    }, body = {
        // Usamos LazyColumn para contener tanto encabezados como elementos de la lista
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            // Sección de Pagos Pendientes
            item {
                Text(
                    text = stringResource(id = R.string.pagos_pendientes),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            items(pagosPendientes) { pago ->
                PaymentItem(month = pago.mes, isPaid = false)
            }

            // Sección de Pagos Realizados
            item {
                Text(
                    text = stringResource(id = R.string.pagos_realizados),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
                )
            }

            items(pagosRealizados) { pago ->
                PaymentItem(month = pago.mes, isPaid = true)
            }

            // Botón para realizar un nuevo pago
            item {
                Button(
                    onClick = { /* Lógica para realizar un pago */ },
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                ) {
                    Text(text = "Realizar Pago Ahora")
                }
            }
        }
    })
}

@Composable
fun PaymentItem(month: String, isPaid: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp)) // Fondo blanco
            .padding(16.dp), // Padding interno
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = month,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
        )

        Icon(
            imageVector = if (isPaid) Icons.Default.Check else Icons.Default.Warning,
            contentDescription = if (isPaid) "Pagado" else "Pendiente",
            tint = if (isPaid) Color.Green else Color.Red
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PayScreenPreview() {
    LaSalleAppTheme {
        PayScreen(innerPadding = PaddingValues(0.dp))
    }
}