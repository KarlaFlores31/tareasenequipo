package com.example.tareasenequipo.tarea4

import androidx.annotation.DrawableRes

data class VideoGame(
    val id: Int,
    val nombre: String,
    val precio: Float,
    val consola: String,
    val clasificacion: GameRating,
    @DrawableRes val imagenResId: Int,
)
