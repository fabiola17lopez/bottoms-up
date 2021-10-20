package com.example.bottomsup.ui.browse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.bottomsup.R
import com.example.bottomsup.databinding.ViewHolderCategoryBinding
import com.example.bottomsup.databinding.ViewHolderHeaderBinding
import java.lang.annotation.ElementType

class BrowseAdapter(
    private val elementList: List<BrowseElement>
) : RecyclerView.Adapter<BrowseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder {
        BrowseElementType.valueOf(viewType)?.let { elementType ->
            val inflater = LayoutInflater.from(parent.context)
            return when (elementType) {
                BrowseElementType.ELEMENT_HEADER -> {
                    BrowseViewHolder.Header(
                        ViewHolderHeaderBinding.inflate(inflater, parent, false)
                    )
                }
                BrowseElementType.ELEMENT_CATEGORY -> {
                    BrowseViewHolder.Category(
                        ViewHolderCategoryBinding.inflate(inflater, parent, false)
                    )
                }
            }
        }

        throw IllegalStateException("Unexpected view type of $viewType")
    }

    override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
        when (holder) {
            is BrowseViewHolder.Header -> holder.bind()
            is BrowseViewHolder.Category -> holder.bind(
                elementList[position] as BrowseElement.Category
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (elementList[position]) {
            is BrowseElement.Header -> BrowseElementType.ELEMENT_HEADER
            is BrowseElement.Category -> BrowseElementType.ELEMENT_CATEGORY
        }.ordinal
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

sealed class BrowseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class Header(private val binding: ViewHolderHeaderBinding): BrowseViewHolder(binding) {
        fun bind() {
            binding.textBrowse.text = binding.root.context.getString(R.string.browse_by_category)
        }
    }

    class Category(private val binding: ViewHolderCategoryBinding): BrowseViewHolder(binding) {
        fun bind(element: BrowseElement.Category) {
            binding.category.text = element.name
        }
    }
}

sealed class BrowseElement {
    object Header : BrowseElement()
    data class Category(val name: String): BrowseElement()
}

enum class BrowseElementType {
    ELEMENT_HEADER,
    ELEMENT_CATEGORY;

    companion object {
        fun valueOf(viewType: Int): BrowseElementType? {
            return values().firstOrNull { it.ordinal == viewType }
        }
    }
}