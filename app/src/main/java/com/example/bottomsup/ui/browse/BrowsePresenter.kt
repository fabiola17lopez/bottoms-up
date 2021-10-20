package com.example.bottomsup.ui.browse

import com.example.bottomsup.data.RecipeRepository

class BrowsePresenter {
    val recipeRepository = RecipeRepository()

    fun getData(): List<String> {
        return recipeRepository.getCategories()
    }
}