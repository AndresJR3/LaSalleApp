package com.example.lasalleapp.ui.screens

import android.content.ClipData.Item
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.components.CircleFace
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ScreenTemplate
import com.example.lasalleapp.ui.utils.Screens

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
fun SettingsScreen(innerPadding : PaddingValues, navController : NavController){
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Configuración",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, color = Color.White)
            )

            Spacer(modifier = Modifier.height(30.dp))


            CircleFace()

            Text(
                text = "Andrés Jaime R",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "Nacimiento: 7/07/04",
                style = MaterialTheme.typography.bodySmall
            )

        }

    }, body = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        ) {
            Text(
                text = "Correo: ajr123@lasallebajio.edu.mx",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Ingeniería en Software y Sistemas Computacionales",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                    .clickable {
                        navController.navigate(Screens.PasswordDetail.route)
                    }
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Cambiar Contraseña",
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Change Password",
                        modifier = Modifier.size(30.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                    .clickable {
                        navController.navigate(Screens.ThemeDetail.route)
                    }
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Cambiar Tema",
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Cambiar Tema",
                        modifier = Modifier.size(30.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    })
}



@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun SettingScreenPreview(){
    val navController = rememberNavController()
    LaSalleAppTheme {
        SettingsScreen(
            innerPadding = PaddingValues(0.dp),
            navController = navController
        )
    }
}

