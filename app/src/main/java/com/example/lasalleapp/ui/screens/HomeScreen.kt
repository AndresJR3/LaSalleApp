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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.components.CardImage
import com.example.lasalleapp.ui.components.Widget
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.utils.Cash
import com.example.lasalleapp.ui.utils.Logout
import com.example.lasalleapp.ui.utils.Task
import com.example.lasalleapp.ui.utils.Screens
import com.example.lasalleapp.ui.utils.communities
import com.example.lasalleapp.ui.utils.newsList

@Composable
fun HomeScreen(innerPadding : PaddingValues, navController : NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        //Header
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .height(270.dp)
                .background(MaterialTheme.colorScheme.primary)
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.lasallebajio.edu.mx/comunidad/images/imagotipos/Elementos%20Gr%C3%A1ficos/Edificios%20en%20vectores-13.png")
                    .build(),
                contentDescription = "BackgrounImage",
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 60.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo Image",
                    modifier = Modifier.size(70.dp)
                )

                Column (
                    modifier = Modifier.weight(1f)
                ){
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
                            Log.i("HomeScreen", "Cerrando sesion")
                        },
                    tint = Color.White
                )

            }
        }

        //widget
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .offset(y = (-40).dp) //mover los objetos ciertas cantdidad de dp
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                //widget
                Widget(
                    icon = Icons.Default.DateRange,
                    text = "Sin eventos",
                    onClick = {}
                )
                Widget(
                    icon = Task,
                    text = "2 Tareas",
                    onClick = {}
                )
                Widget(
                    icon = Cash,
                    text = stringResource(id = R.string.cash_text),
                    onClick = { navController.navigate(Screens.PayScreen.route) }

                )

            }

        }

        //Body
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)

        ){
            Column(
                modifier = Modifier
                    .padding(20.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.news),
                    style = MaterialTheme.typography.titleLarge
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(newsList){ news ->
                        CardImage(news = news){
                            navController.navigate(Screens.NewsDetail.route + "/${news.id}")
                        }
                    }
                }
                Text(
                    text = "Comunidad",
                    modifier = Modifier.padding(top = 20.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                ) {
                    items(communities){
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .size(180.dp)
                                .padding(16.dp)
                        ){
                            AsyncImage(model = it.image,
                                contentDescription = it.id.toString(),
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    LaSalleAppTheme {
        HomeScreen(
            innerPadding = PaddingValues(0.dp),
            navController = navController
        )
    }
}