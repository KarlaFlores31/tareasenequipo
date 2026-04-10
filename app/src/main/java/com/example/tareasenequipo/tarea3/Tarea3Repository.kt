package com.example.tareasenequipo.tarea3

// Lista falsa de alumnos y materias para la tarea (todo en memoria).
object Tarea3Repository {

    private val degree =
        "Licenciatura en Ingeniería en Sistemas y Negocios Digitales (Plan 2020)"

    private val students: List<Student> = listOf(
        Student(
            id = 20057,
            name = "AMIR DORTAJ RESENDIZ",
            email = "amir.dortaj@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Lectura de ciencia ficción",
            average = 9.2,
            currentSubjects = listOf(
                "Programación móvil",
                "Bases de datos avanzadas",
                "Sistemas distribuidos"
            )
        ),
        Student(
            id = 20091,
            name = "RODRIGO CASAS TELLEZ",
            email = "rodrigo.casas@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Ciclismo urbano",
            average = 8.7,
            currentSubjects = listOf(
                "Programación móvil",
                "Inteligencia artificial",
                "Seguridad informática"
            )
        ),
        Student(
            id = 20050,
            name = "MARÍA FERNANDA LÓPEZ",
            email = "maria.lopez@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Fotografía",
            average = 9.5,
            currentSubjects = listOf(
                "Matemáticas discretas",
                "Estructuras de datos",
                "Programación orientada a objetos"
            )
        ),
        Student(
            id = 20065,
            name = "JOSÉ ANTONIO RUIZ",
            email = "jose.ruiz@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Videojuegos",
            average = 8.1,
            currentSubjects = listOf(
                "Redes de computadoras",
                "Sistemas operativos",
                "Programación web"
            )
        ),
        Student(
            id = 20073,
            name = "ANA PAULA MENDOZA",
            email = "ana.mendoza@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Senderismo",
            average = 9.0,
            currentSubjects = listOf(
                "Ingeniería de software",
                "Pruebas de software",
                "Gestión de proyectos TI"
            )
        ),
        Student(
            id = 20082,
            name = "LUIS ENRIQUE VEGA",
            email = "luis.vega@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Música electrónica",
            average = 7.9,
            currentSubjects = listOf(
                "Compiladores",
                "Automatización",
                "Ética profesional"
            )
        ),
        Student(
            id = 20110,
            name = "DANIELA HERRERA",
            email = "daniela.herrera@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Pintura al óleo",
            average = 9.3,
            currentSubjects = listOf(
                "Big data",
                "Minería de datos",
                "Estadística aplicada"
            )
        ),
        Student(
            id = 20145,
            name = "CARLOS EDUARDO NÚÑEZ",
            email = "carlos.nunez@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Ajedrez",
            average = 8.4,
            currentSubjects = listOf(
                "Arquitectura de computadoras",
                "Electrónica digital",
                "Interfaces de usuario"
            )
        ),
        Student(
            id = 20178,
            name = "SOFÍA RAMÍREZ",
            email = "sofia.ramirez@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Voluntariado ambiental",
            average = 9.1,
            currentSubjects = listOf(
                "Programación móvil",
                "UX/UI",
                "Accesibilidad"
            )
        ),
        Student(
            id = 20195,
            name = "JAVIER ORTIZ",
            email = "javier.ortiz@iest.edu.mx",
            degreeDescription = degree,
            career = "Ingeniería en Sistemas y Negocios Digitales",
            hobby = "Running",
            average = 8.0,
            currentSubjects = listOf(
                "Cloud computing",
                "Contenedores",
                "DevOps básico"
            )
        )
    )

    private val subjectsByStudentId: Map<Int, List<Subject>> = mapOf(
        20057 to listOf(
            Subject("m1", "Programación móvil", 1, 9.5),
            Subject("m2", "Bases de datos avanzadas", 0, 9.0),
            Subject("m3", "Sistemas distribuidos", 2, 9.0)
        ),
        20091 to listOf(
            Subject("m1", "Programación móvil", 0, 8.5),
            Subject("m2", "Inteligencia artificial", 1, 9.0),
            Subject("m3", "Seguridad informática", 3, 8.5)
        ),
        20050 to listOf(
            Subject("m1", "Matemáticas discretas", 0, 10.0),
            Subject("m2", "Estructuras de datos", 1, 9.2),
            Subject("m3", "Programación orientada a objetos", 0, 9.3)
        ),
        20065 to listOf(
            Subject("m1", "Redes de computadoras", 2, 8.0),
            Subject("m2", "Sistemas operativos", 1, 8.2),
            Subject("m3", "Programación web", 0, 8.0)
        ),
        20073 to listOf(
            Subject("m1", "Ingeniería de software", 0, 9.5),
            Subject("m2", "Pruebas de software", 1, 8.8),
            Subject("m3", "Gestión de proyectos TI", 0, 9.0)
        ),
        20082 to listOf(
            Subject("m1", "Compiladores", 4, 7.5),
            Subject("m2", "Automatización", 2, 8.0),
            Subject("m3", "Ética profesional", 0, 8.5)
        ),
        20110 to listOf(
            Subject("m1", "Big data", 0, 9.5),
            Subject("m2", "Minería de datos", 1, 9.2),
            Subject("m3", "Estadística aplicada", 0, 9.0)
        ),
        20145 to listOf(
            Subject("m1", "Arquitectura de computadoras", 1, 8.5),
            Subject("m2", "Electrónica digital", 2, 8.0),
            Subject("m3", "Interfaces de usuario", 0, 8.8)
        ),
        20178 to listOf(
            Subject("m1", "Programación móvil", 0, 9.5),
            Subject("m2", "UX/UI", 1, 9.0),
            Subject("m3", "Accesibilidad", 0, 9.0)
        ),
        20195 to listOf(
            Subject("m1", "Cloud computing", 2, 8.0),
            Subject("m2", "Contenedores", 1, 8.5),
            Subject("m3", "DevOps básico", 3, 7.5)
        )
    )

    fun allStudents(): List<Student> {
        return students
    }

    fun getStudent(id: Int): Student? {
        for (alumno in students) {
            if (alumno.id == id) {
                return alumno
            }
        }
        return null
    }

    private val defaultSubjects = listOf(
        Subject("d1", "Materia optativa I", 1, 8.5),
        Subject("d2", "Materia optativa II", 0, 9.0),
        Subject("d3", "Seminario de titulación", 2, 8.0)
    )

    fun getSubjectsForStudent(studentId: Int): List<Subject> {
        val lista = subjectsByStudentId[studentId]
        if (lista != null) {
            return lista
        }
        return defaultSubjects
    }

    fun getSubject(studentId: Int, index: Int): Subject? {
        val listaMaterias = getSubjectsForStudent(studentId)
        if (index < 0) {
            return null
        }
        if (index >= listaMaterias.size) {
            return null
        }
        return listaMaterias[index]
    }
}
