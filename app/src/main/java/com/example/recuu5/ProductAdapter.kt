package com.example.recuu5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recuu5.databinding.ItemProductBinding
import com.example.recuu5.model.Product

class ProductAdapter(private val onProductClicked: (Product) -> Unit) :
    ListAdapter<Product, ProductAdapter.ViewHolder>(ProductCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = getItem(position)
        holder.binding.tvNombre.text = product.name
        holder.binding.ivIProducto.setImageResource(product.image)
        holder.binding.root.setOnClickListener {
            onProductClicked(product)
        }
    }

    inner class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

}

object ProductCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem

}