package com.example.lasalleapp.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import com.example.lasalleapp.models.Grades
import com.example.lasalleapp.models.BottomNavigationItem
import com.example.lasalleapp.models.Community
import com.example.lasalleapp.models.News


val newsList = listOf(
    News(
        id = 1,
        title = "Evento de Construcción de la Paz",
        description = "La Salle Bajío realiza un foro para fomentar la construcción de la paz en la comunidad estudiantil.",
        image =  "https://www.lasallebajio.edu.mx/noticias/images/4701_1.jpg"
    ),
    News(
        id = 2,
        title = "Conferencia de Liderazgo",
        description = "Una conferencia que destaca la importancia del liderazgo en la comunidad universitaria.",
        image = "https://www.lasallebajio.edu.mx/noticias/images/4701_2.jpg"
    ),
    News(
        id = 3,
        title = "Semana Cultural 2024",
        description = "Celebración anual de la Semana Cultural con diversas actividades artísticas y deportivas.",
        image = "https://www.lasallebajio.edu.mx/noticias/images/4701_3.jpg"
    )
)

val bottomNavBarItems = listOf(
    BottomNavigationItem(
        title = "Inicio",
        icon = Icons.Default.Home,
        route = Screens.Home.route
    ),
    BottomNavigationItem(
        title = "Calificaciones",
        icon = Icons.Default.Menu,
        route = Screens.Grades.route
    ),
    BottomNavigationItem(
        title = "Calendario",
        icon = Icons.Default.DateRange,
        route = Screens.Calendar.route
    ),
    BottomNavigationItem(
        title = "Configuracion",
        icon = Icons.Default.Settings,
        route = Screens.Settings.route
    )
)

val communities = listOf(
    Community(1,"https://www.lasallebajio.edu.mx/comunidad/images/tile_documentos_inspiradores.jpg"),
    Community(2,"https://www.lasallebajio.edu.mx/comunidad/images/tile_boletin.jpg"),
    Community(3,"https://www.lasallebajio.edu.mx/comunidad/images/tile_cat_souv_22.jpg  "),
    Community(4,"https://www.lasallebajio.edu.mx/comunidad/images/tile_tramites.jpg"),
    Community(5,"https://www.lasallebajio.edu.mx/comunidad/images/tile_blog.jpg")
)
val gradesList = listOf(
    Grades(
        id = 1,
        name = "Administración de Bases de Datos",
        partial1 = 9.5,
        partial2 = 9.0,
        partial3 = 8.7,
        finalAverage = (9.5 + 9.0 + 8.7) / 3
    ),
    Grades(
        id = 2,
        name = "Administración de Proyectos",
        partial1 = 8.9,
        partial2 = 9.1,
        partial3 = 9.3,
        finalAverage = (8.9 + 9.1 + 9.3) / 3
    ),
    Grades(
        id = 3,
        name = "Cristianismo",
        partial1 = 7.0,
        partial2 = 6.5,
        partial3 = 6.0,
        finalAverage = (7.0 + 6.5 + 6.0) / 3
    ),
    Grades(
        id = 4,
        name = "Metodología de la Investigación",
        partial1 = 9.0,
        partial2 = 9.3,
        partial3 = 9.2,
        finalAverage = (9.0 + 9.3 + 9.2) / 3
    ),
    Grades(
        id = 5,
        name = "Modelado de Imágenes",
        partial1 = 8.8,
        partial2 = 9.0,
        partial3 = 8.9,
        finalAverage = (8.8 + 9.0 + 8.9) / 3
    ),
    Grades(
        id = 6,
        name = "Modelos Abstractos",
        partial1 = 9.0,
        partial2 = 9.1,
        partial3 = 9.2,
        finalAverage = (9.0 + 9.1 + 9.2) / 3
    ),
    Grades(
        id = 7,
        name = "Redes de Área Local",
        partial1 = 8.7,
        partial2 = 9.0,
        partial3 = 9.1,
        finalAverage = (8.7 + 9.0 + 9.1) / 3
    ),
    Grades(
        id = 8,
        name = "Taller Desarrollo Móvil Windows",
        partial1 = 10.0,
        partial2 = 10.0,
        partial3 = 10.0,
        finalAverage = 10.0
    )
)


