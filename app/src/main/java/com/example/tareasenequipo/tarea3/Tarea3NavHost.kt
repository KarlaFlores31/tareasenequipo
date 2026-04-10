package com.example.tareasenequipo.tarea3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Tarea3NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Tarea3Routes.LOGIN,
        modifier = modifier
    ) {
        composable(Tarea3Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = { name, id, role ->
                    Tarea3Session.setSession(name, id, role)
                    // Según el rol, mandamos a una pantalla u otra.
                    if (role == UserRole.Coordinator) {
                        navController.navigate(Tarea3Routes.COORDINATOR_LIST) {
                            popUpTo(Tarea3Routes.LOGIN) { inclusive = true }
                        }
                    } else if (role == UserRole.Student) {
                        navController.navigate(Tarea3Routes.STUDENT_SUBJECTS) {
                            popUpTo(Tarea3Routes.LOGIN) { inclusive = true }
                        }
                    }
                },
            )
        }
        composable(Tarea3Routes.COORDINATOR_LIST) {
            CoordinatorListScreen(
                onStudentClick = { studentId ->
                    navController.navigate(Tarea3Routes.studentDetail(studentId))
                },
                onLogout = {
                    Tarea3Session.clear()
                    navController.navigate(Tarea3Routes.LOGIN) {
                        popUpTo(navController.graph.id) { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = Tarea3Routes.STUDENT_DETAIL,
            arguments = listOf(navArgument("studentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val args = backStackEntry.arguments
            if (args == null) {
                return@composable
            }
            val studentId = args.getInt("studentId")
            CoordinatorStudentDetailScreen(
                studentId = studentId,
                onBack = { navController.popBackStack() },
            )
        }
        composable(Tarea3Routes.STUDENT_SUBJECTS) {
            // El id sale de lo que guardamos al iniciar sesión.
            val idAlumnoEnSesion = Tarea3Session.userId
            StudentSubjectsScreen(
                studentId = idAlumnoEnSesion,
                onSubjectClick = { indiceMateria ->
                    val ruta = Tarea3Routes.subjectDetail(idAlumnoEnSesion, indiceMateria)
                    navController.navigate(ruta)
                },
                onLogout = {
                    Tarea3Session.clear()
                    navController.navigate(Tarea3Routes.LOGIN) {
                        popUpTo(navController.graph.id) { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = Tarea3Routes.SUBJECT_DETAIL,
            arguments = listOf(
                navArgument("studentId") { type = NavType.IntType },
                navArgument("subjectIndex") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val args = backStackEntry.arguments
            if (args == null) {
                return@composable
            }
            val studentId = args.getInt("studentId")
            val subjectIndex = args.getInt("subjectIndex")
            SubjectDetailScreen(
                studentId = studentId,
                subjectIndex = subjectIndex,
                onBack = { navController.popBackStack() },
            )
        }
    }
}
