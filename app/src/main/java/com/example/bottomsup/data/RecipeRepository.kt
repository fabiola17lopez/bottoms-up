package com.example.bottomsup.data

class RecipeRepository {
    fun getCategories(): List<String> {
        return listOf(
            "Ordinary Drink",
            "Cocktail",
            "Milk/ Float/ Shake",
            "Other/ Unknown",
            "Cocoa",
            "Shot",
            "Coffee/ Tea",
            "Homemade Liqueur",
            "Punch/ Party Drink",
            "Beer",
            "Soft Drink/ Soda",
        )
    }
}