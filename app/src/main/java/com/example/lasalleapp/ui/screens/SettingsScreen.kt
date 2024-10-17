package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

//nombre completo, fecha de nacimiento, correo electrónico institucional e
// imagen circular del alumno.
//
//• Mostrar una lista de opciones con las siguientes dos entradas:
//
//• Cambiar contraseña (no es necesario implementar la funcionalidad,
// solo la navegación a una nueva pantalla vacía).
//
//• Cambiar tema de la aplicación (similar al anterior, solo la navegación).

@Composable
fun SettingsScreen(innerPadding : PaddingValues){
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ){

        }

    }, body = {
        Text(text = "Hola")
    })
}



@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun SettingScreenPreview(){
    LaSalleAppTheme {
        SettingsScreen(innerPadding = PaddingValues(0.dp))
    }
}

