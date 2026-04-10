package com.example.tareasenequipo.tarea3

object Tarea3Routes {
    const val LOGIN = "login"
    const val COORDINATOR_LIST = "coordinator_list"
    const val STUDENT_SUBJECTS = "student_subjects"
    const val STUDENT_DETAIL = "student_detail/{studentId}"
    const val SUBJECT_DETAIL = "subject_detail/{studentId}/{subjectIndex}"

    fun studentDetail(studentId: Int): String {
        return "student_detail/$studentId"
    }

    fun subjectDetail(studentId: Int, subjectIndex: Int): String {
        return "subject_detail/$studentId/$subjectIndex"
    }
}
