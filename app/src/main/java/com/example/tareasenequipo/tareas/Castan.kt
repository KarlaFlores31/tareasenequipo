package com.example.tareasenequipo.tareas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tareasenequipo.R

@Preview(showBackground = true)
@Composable

fun Multiservicios (){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF252728))){
        Column() {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                .padding(top = 50.dp)
                .size(width = 400.dp , height = 200.dp)
                .background(color = Color(0xFF294C69))){
                Image(painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                    Modifier
                        .size(150.dp)
                        .border(width = 3.dp, color = Color(0xFF252728), shape = CircleShape)
                        .clip(CircleShape))
            }
            Box(){
                Text(text = "")
            }
            Box(){
                Text(text = "")
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                .size(width = 400.dp , height = 40.dp)) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                    .size(width = 100.dp , height = 40.dp)
                    .background(color = Color(0xFF0F66FF), shape = RoundedCornerShape(8.dp))){
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
                        .background(color = Color(0xFF3B3D3E), shape = RoundedCornerShape(8.dp))){
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.AddCircle,
                            contentDescription = "mensaje",
                            tint = Color(0xffffffff))
                        Text(text = " Seguir",
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
        }
    }
}