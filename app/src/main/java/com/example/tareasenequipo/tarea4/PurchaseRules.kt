package com.example.tareasenequipo.tarea4

object PurchaseRules {
    private const val ADULT_AGE = 18

    fun canPurchase(age: Int, rating: GameRating): Boolean {
        if (age == 5) {
            return rating != GameRating.T && rating != GameRating.R
        }
        if (age < ADULT_AGE) {
            return rating != GameRating.R
        }
        return true
    }
}
