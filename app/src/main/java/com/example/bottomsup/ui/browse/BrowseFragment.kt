package com.example.bottomsup.ui.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsup.R
import com.example.bottomsup.databinding.FragmentBrowseBinding

class BrowseFragment : Fragment() {

    private lateinit var browsePresenter: BrowsePresenter
    private var _binding: FragmentBrowseBinding? = null
    private lateinit var browseAdapter: BrowseAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBrowseBinding.inflate(inflater, container, false)
        val root: View = binding.root
        browsePresenter = BrowsePresenter()

        setCategoryList()
        return root
    }

    private fun setCategoryList() {
        val data = browsePresenter.getData()

        browseAdapter = BrowseAdapter(data)
        binding.categoryList.apply {
            adapter = browseAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}