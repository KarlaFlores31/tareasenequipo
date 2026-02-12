package com.example.tareasenequipo.tareas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tareasenequipo.R

@Preview(showBackground = true)
@Composable
fun Multiservicios (){

    var textoDescripcion by remember {
        mutableStateOf(
            "En Multiservicios Castan ofrecemos todo tipo de servicios para el mantenimiento y reparación del hogar en Tampico, Tamaulipas. Desde aire acondicionado, pintura, plomería y electricidad, hasta albañilería, herrería e impermeabilizado.") }

    var siguiendo by remember { mutableStateOf(false) }

    var cambiarImagen by remember { mutableStateOf(false) }

    var nombreNegocio by remember {
        mutableStateOf("Multiservicios Castan: Soluciones para tu hogar en Tampico")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF252728))){
        Column {

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .size(width = 400.dp , height = 200.dp)
                    .background(color = Color(0xFF294C69))){

                Image(
                    painter = painterResource(
                        if (cambiarImagen) R.drawable.castan2 else R.drawable.logo
                    ),
                    contentDescription = "logo",
                    Modifier
                        .size(150.dp)
                        .border(width = 3.dp, color = Color(0xFF252728), shape = CircleShape)
                        .clip(CircleShape)
                        .clickable {
                            cambiarImagen = !cambiarImagen
                        }
                )
            }

            TextField(
                value = nombreNegocio,
                onValueChange = { nombreNegocio = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            Box(modifier = Modifier.fillMaxWidth()
                .padding(top = 12.dp), contentAlignment = Alignment.Center)
            {
                Text(text = nombreNegocio,
                    color = Color.White, fontWeight = FontWeight.Bold, fontSize = 40.sp,
                    textAlign = TextAlign.Center, lineHeight = 33.sp)
            }

            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center)
            {
                Text(text = "128 seguidores · 1 seguido",
                    color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium,
                    lineHeight = 30.sp)
            }

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .size(width = 400.dp , height = 40.dp)) {

                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(width = 100.dp , height = 40.dp)
                        .background(color = Color(0xFF0F66FF), shape = RoundedCornerShape(8.dp))
                        .clickable {
                            textoDescripcion =
                                "Estamos trabajando en nuestra nueva plataforma digital para brindarte una experiencia mejorada."
                        }){

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Call,
                            contentDescription = "mensaje",
                            tint = Color(0xffffffff))
                        Text(text = " Mensaje",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffffffff))
                    }
                }

                Spacer(modifier = Modifier.width(5.dp))

                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(width = 100.dp , height = 40.dp)
                        .background(color = Color(0xFF3B3D3E), shape = RoundedCornerShape(8.dp))
                        .clickable {
                            siguiendo = !siguiendo
                        }){

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.AddCircle,
                            contentDescription = "mensaje",
                            tint = Color(0xffffffff))
                        Text(text = if (siguiendo) " Siguiendo" else " Seguir",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffffffff))
                    }
                }

                Spacer(modifier = Modifier.width(5.dp))

                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(width = 100.dp , height = 40.dp)
                        .background(color = Color(0xFF3B3D3E), shape = RoundedCornerShape(8.dp))){

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = "mensaje",
                            tint = Color(0xffffffff))
                        Text(text = " Buscar",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffffffff))
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = textoDescripcion,
                    color = Color(0xFFB0B3B8),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 20.sp
                )
            }

        }
    }
}
