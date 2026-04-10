package com.example.tareasenequipo.tarea4

import com.example.tareasenequipo.R

object Tarea4Repository {
    val videojuegos: List<VideoGame> = listOf(
        VideoGame(
            id = 1,
            nombre = "Aventura Pixel",
            precio = 29.99f,
            consola = "Nintendo Switch",
            clasificacion = GameRating.E,
            imagenResId = R.drawable.game_thumb_1,
        ),
        VideoGame(
            id = 2,
            nombre = "Carreras Deluxe",
            precio = 49.99f,
            consola = "Nintendo Switch",
            clasificacion = GameRating.E10_PLUS,
            imagenResId = R.drawable.game_thumb_2,
        ),
        VideoGame(
            id = 3,
            nombre = "Arena Battle",
            precio = 39.99f,
            consola = "PlayStation 5",
            clasificacion = GameRating.T,
            imagenResId = R.drawable.game_thumb_3,
        ),
        VideoGame(
            id = 4,
            nombre = "Operación Nocturna",
            precio = 59.99f,
            consola = "Xbox Series X",
            clasificacion = GameRating.M,
            imagenResId = R.drawable.game_thumb_4,
        ),
        VideoGame(
            id = 5,
            nombre = "Ciudad Libre",
            precio = 69.99f,
            consola = "PlayStation 5",
            clasificacion = GameRating.R,
            imagenResId = R.drawable.game_thumb_5,
        ),
        VideoGame(
            id = 6,
            nombre = "Puzle Zen",
            precio = 14.99f,
            consola = "PC",
            clasificacion = GameRating.E,
            imagenResId = R.drawable.game_thumb_6,
        ),
    )
}
