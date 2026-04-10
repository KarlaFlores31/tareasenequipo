package com.example.tareasenequipo.tarea3

// Revisa el texto de la matrícula y el tipo de usuario (coordinador o alumno).
object LoginValidator {

    fun parseId(texto: String): Int? {
        val sinEspacios = texto.trim()
        val numero = sinEspacios.toIntOrNull()
        return numero
    }

    fun validate(id: Int): UserRole? {
        // Coordinadores del 1 al 10 (así lo pide la práctica).
        if (id >= 1 && id <= 10) {
            return UserRole.Coordinator
        }
        // Alumnos en un rango de matrícula.
        if (id >= 20050 && id <= 20200) {
            return UserRole.Student
        }
        return null
    }
}