package com.example.bottomsup.ui.browse

import com.example.bottomsup.data.RecipeRepository

class BrowsePresenter {
    private val recipeRepository = RecipeRepository()

    fun getData(): List<BrowseElement> {
        val elements = mutableListOf<BrowseElement>(BrowseElement.Header)
        elements.addAll(recipeRepository.getCategories().map { BrowseElement.Category(it) })
        return elements
    }
}