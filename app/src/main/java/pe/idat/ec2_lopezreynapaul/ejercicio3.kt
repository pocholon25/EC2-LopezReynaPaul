package pe.idat.ec2_lopezreynapaul

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Concierto(val titulo: String, val descripcion: String, val fecha: String)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun ComponenteTwo() {
    var mostrar by remember { mutableStateOf(false) }
    val conciertos = listOf(
        Concierto("Concierto 1", "Descripción  1", "01/01/2024"),
        Concierto("Concierto 2", "Descripción  2", "02/01/2024"),
        Concierto("Concierto 3", "Descripción  3", "03/01/2024"),
        Concierto("Concierto 4", "Descripción  4", "04/01/2024"),
        Concierto("Concierto 5", "Descripción  5", "05/01/2024"),
        Concierto("Concierto 6", "Descripción  6", "06/01/2024"),
        Concierto("Concierto 7", "Descripción  7", "07/01/2024"),
        Concierto("Concierto 8", "Descripción  8", "08/01/2024"),
        Concierto("Concierto 9", "Descripción  9", "09/01/2024"),
        Concierto("Concierto 10", "Descripción 10", "10/01/2024")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "AppIDAT") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.jugador), contentDescription = "")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Button(
                onClick = { mostrar = !mostrar },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (mostrar) "Ocultar Conciertos" else "Mostrar Conciertos")
            }
            if (mostrar) {
                ListaConciertos(conciertos)
            }
        }
    }
}

@Composable
fun ListaConciertos(conciertos: List<Concierto>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(conciertos) { concierto ->
            ConciertoCard(concierto)
        }
    }
}

@Composable
fun ConciertoCard(concierto: Concierto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = concierto.titulo, fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = concierto.descripcion, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = concierto.fecha, fontSize = 14.sp, color = Color.Gray)
        }
    }
}