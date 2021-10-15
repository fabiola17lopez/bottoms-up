package com.example.bottomsup.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsup.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homePresenter: HomePresenter
    private var _binding: FragmentHomeBinding? = null
    private lateinit var categoryAdapter: CategoryAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homePresenter = HomePresenter()

        binding.textHome.text = "Featured"

        setCategoryList()
        return root
    }

    private fun setCategoryList() {
        val data = homePresenter.getData()

        categoryAdapter = CategoryAdapter(data)
        binding.categoryList.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}