package com.example.tareasenequipo.tarea3

data class Student(
    val id: Int,
    val name: String,
    val email: String,
    val degreeDescription: String,
    val career: String,
    val hobby: String,
    val average: Double,
    val currentSubjects: List<String>
)
