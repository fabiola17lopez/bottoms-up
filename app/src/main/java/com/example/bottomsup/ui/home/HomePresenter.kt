package com.example.bottomsup.ui.home

import com.example.bottomsup.data.RecipeRepository

class HomePresenter {
    val recipeRepository = RecipeRepository()

    fun getData(): List<String> {
        return recipeRepository.getCategories()
    }
}