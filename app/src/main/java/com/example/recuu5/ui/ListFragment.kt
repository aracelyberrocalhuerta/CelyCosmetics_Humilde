package com.example.recuu5.ui

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recuu5.ProductAdapter
import com.example.recuu5.databinding.FragmentListBinding
import com.example.recuu5.model.Product
import com.example.recuu5.products

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val adapter = ProductAdapter(::onProductClicked)

    private fun onProductClicked(product: Product) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(product.id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        adapter.submitList(products)

        binding.etSearch.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                val name = binding.etSearch.text.toString().lowercase()
                val listFilter = products.filter { product ->
                    product.name.lowercase().contains(name)
                }
                adapter.submitList(listFilter)
                return@OnKeyListener true
            }
            false
        })
    }

}