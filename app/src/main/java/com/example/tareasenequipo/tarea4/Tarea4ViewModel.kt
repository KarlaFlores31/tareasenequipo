package com.example.tareasenequipo.tarea4

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Tarea4ViewModel : ViewModel() {

    var userName by mutableStateOf("")
        private set

    var userAge by mutableIntStateOf(0)
        private set

    var walletInitial by mutableFloatStateOf(0f)
        private set

    var remainingBalance by mutableFloatStateOf(0f)
        private set

    var layoutVertical by mutableStateOf(true)
        private set

    private val addedIds = mutableStateMapOf<Int, Boolean>()

    val games: List<VideoGame> = Tarea4Repository.videojuegos

    val totalSpent: Float
        get() = walletInitial - remainingBalance

    var finishDialogVisible by mutableStateOf(false)
        private set

    fun initSession(name: String, age: Int, wallet: Float) {
        userName = name.trim()
        userAge = age
        walletInitial = wallet
        remainingBalance = wallet
        addedIds.clear()
        games.forEach { addedIds[it.id] = false }
        finishDialogVisible = false
    }

    fun updateLayoutVertical(vertical: Boolean) {
        layoutVertical = vertical
    }

    fun isAdded(gameId: Int): Boolean = addedIds[gameId] == true

    fun tryAddGame(game: VideoGame): AddGameResult {
        if (isAdded(game.id)) return AddGameResult.AlreadyAdded
        if (!PurchaseRules.canPurchase(userAge, game.clasificacion)) {
            return AddGameResult.BlockedByAge(game.clasificacion)
        }
        if (game.precio > remainingBalance) {
            return AddGameResult.InsufficientFunds
        }
        addedIds[game.id] = true
        remainingBalance -= game.precio
        return AddGameResult.Success
    }

    fun openFinishDialog() {
        finishDialogVisible = true
    }

    fun dismissFinishDialog() {
        finishDialogVisible = false
    }

    fun reasonCannotAdd(game: VideoGame): String? {
        if (isAdded(game.id)) return null
        if (!PurchaseRules.canPurchase(userAge, game.clasificacion)) {
            if (userAge == 5) {
                return when (game.clasificacion) {
                    GameRating.T -> "A los 5 años no puedes comprar juegos T."
                    GameRating.R -> "A los 5 años no puedes comprar juegos R."
                    else -> "No puedes comprar este juego por tu edad."
                }
            }
            if (userAge < 18 && game.clasificacion == GameRating.R) {
                return "Los menores de 18 no pueden comprar juegos clasificación R."
            }
            return "No puedes comprar este juego por tu edad."
        }
        if (game.precio > remainingBalance) {
            return "Saldo insuficiente."
        }
        return null
    }
}

sealed class AddGameResult {
    data object Success : AddGameResult()
    data object AlreadyAdded : AddGameResult()
    data object InsufficientFunds : AddGameResult()
    data class BlockedByAge(val rating: GameRating) : AddGameResult()
}
