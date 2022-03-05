package com.example.recuu5

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recuu5.databinding.ItemProductBinding
import com.example.recuu5.model.Product
import kotlin.math.round

class ProductAdapter(private val onProductClicked: (Product) -> Unit) :
    ListAdapter<Product, ProductAdapter.ViewHolder>(ProductCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = getItem(position)
        holder.binding.tvNombre.text = product.name.uppercase()
        holder.binding.ivIProducto.setImageResource(product.image)
        val priceDiscount = (product.price * product.discount) / 100
        val priceWithDiscount = (product.price - priceDiscount)
        holder.binding.tvPrecio.text = priceWithDiscount.round(2).toString() + "€"
        when (product.stock) {
            1 -> holder.binding.ivIcono2.setImageResource(R.drawable.ic_baseline_looks_one_24)
            2 -> holder.binding.ivIcono2.setImageResource(R.drawable.ic_baseline_looks_two_24)
            3 -> holder.binding.ivIcono2.setImageResource(R.drawable.ic_baseline_looks_3_24)
            4 -> holder.binding.ivIcono2.setImageResource(R.drawable.ic_baseline_looks_4_24)
            5 -> holder.binding.ivIcono2.setImageResource(R.drawable.ic_baseline_looks_5_24)
            else -> {
                holder.binding.ivIcono2.isVisible = false

            }
        }
        holder.binding.ivIcono2.setColorFilter(Color.RED);
        holder.binding.ivIcono2.isVisible = product.stock < 5
        holder.binding.root.setOnClickListener {
            onProductClicked(product)
        }
    }

    private fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
    inner class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

}

object ProductCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem

}