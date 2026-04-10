package com.example.tareasenequipo.tarea4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun Tarea4NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Tarea4Routes.GRAPH,
        modifier = modifier,
    ) {
        navigation(
            route = Tarea4Routes.GRAPH,
            startDestination = Tarea4Routes.INPUT,
        ) {
            composable(Tarea4Routes.INPUT) {
                val parentEntry = remember(navController) {
                    navController.getBackStackEntry(Tarea4Routes.GRAPH)
                }
                val viewModel: Tarea4ViewModel = viewModel(parentEntry)
                UserInputScreen(
                    onContinue = { name, age, money ->
                        viewModel.initSession(name, age, money)
                        navController.navigate(Tarea4Routes.GAMES)
                    },
                )
            }
            composable(Tarea4Routes.GAMES) {
                val parentEntry = remember(navController) {
                    navController.getBackStackEntry(Tarea4Routes.GRAPH)
                }
                val viewModel: Tarea4ViewModel = viewModel(parentEntry)
                GameListScreen(
                    viewModel = viewModel,
                    onBack = { navController.popBackStack() },
                )
            }
        }
    }
}
