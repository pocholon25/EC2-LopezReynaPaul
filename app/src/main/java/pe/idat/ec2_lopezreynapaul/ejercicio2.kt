package pe.idat.ec2_lopezreynapaul

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponenteOne() {
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
        },
        content = { paddingValues ->
            InformacionForm(Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun InformacionForm(modifier: Modifier = Modifier) {
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var msSqlServerChecked by remember { mutableStateOf(false) }
    var vStudioCodeChecked by remember { mutableStateOf(false) }
    var androidStudioChecked by remember { mutableStateOf(false) }
    var otherChecked by remember { mutableStateOf(false) }
    var otherProgram by remember { mutableStateOf("") }

    var favoriteColor by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        item {
            Text(text = "INFORMACIÓN", fontSize = 24.sp, color = Color.Blue)
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            OutlinedTextField(
                value = nombres,
                onValueChange = { nombres = it },
                label = { Text("Nombres") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )
        }
        item {
            OutlinedTextField(
                value = apellidos,
                onValueChange = { apellidos = it },
                label = { Text("Apellidos") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )
        }
        item {
            OutlinedTextField(
                value = dni,
                onValueChange = { dni = it },
                label = { Text("DNI") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )
        }
        item {
            OutlinedTextField(
                value = celular,
                onValueChange = { celular = it },
                label = { Text("Celular") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )
        }
        item {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(text = "Seleccione Programas que domine:")
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = msSqlServerChecked, onCheckedChange = { msSqlServerChecked = it })
                Text(text = "MS SQL Server")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = vStudioCodeChecked, onCheckedChange = { vStudioCodeChecked = it })
                Text(text = "VStudioCode")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = androidStudioChecked, onCheckedChange = { androidStudioChecked = it })
                Text(text = "Android Studio")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = otherChecked, onCheckedChange = { otherChecked = it })
                Text(text = "Otro")
            }
        }
        if (otherChecked) {
            item {
                OutlinedTextField(
                    value = otherProgram,
                    onValueChange = { otherProgram = it },
                    label = { Text("Ingrese otro programa") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    singleLine = true
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(text = "Seleccione su color favorito:")
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = favoriteColor == "Azul", onClick = { favoriteColor = "Azul" })
                Text(text = "Azul")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = favoriteColor == "Rojo", onClick = { favoriteColor = "Rojo" })
                Text(text = "Rojo")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = favoriteColor == "Verde", onClick = { favoriteColor = "Verde" })
                Text(text = "Verde")
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = favoriteColor == "Otro", onClick = { favoriteColor = "Otro" })
                Text(text = "Otro")
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Acceder")
            }
        }
    }
}
