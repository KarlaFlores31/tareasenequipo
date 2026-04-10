package com.example.tareasenequipo.tarea3

// Datos del usuario mientras la app sigue abierta (no es base de datos real).
object Tarea3Session {
    var userName: String = ""
    var userId: Int = 0
    var role: UserRole? = null

    fun setSession(name: String, id: Int, userRole: UserRole) {
        userName = name
        userId = id
        role = userRole
    }

    fun clear() {
        userName = ""
        userId = 0
        role = null
    }
}
