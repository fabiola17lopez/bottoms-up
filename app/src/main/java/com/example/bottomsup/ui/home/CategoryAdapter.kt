package com.example.bottomsup.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsup.databinding.ViewHolderCategoryBinding

class CategoryAdapter(
    private val categoryList: List<String>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ViewHolderCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class CategoryViewHolder(private val binding: ViewHolderCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryName: String) {
            binding.category.text = categoryName
        }
    }
}