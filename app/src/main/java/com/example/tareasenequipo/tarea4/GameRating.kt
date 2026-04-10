package com.example.tareasenequipo.tarea4

enum class GameRating(val code: String) {
    E("E"),
    E10_PLUS("E10+"),
    T("T"),
    M("M"),
    R("R");

    companion object {
        fun fromCode(code: String): GameRating =
            entries.firstOrNull { it.code.equals(code.trim(), ignoreCase = true) }
                ?: E
    }
}
