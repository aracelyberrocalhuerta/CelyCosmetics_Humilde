package com.example.recuu5.ui

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.recuu5.databinding.FragmentDetailBinding
import com.example.recuu5.model.Product
import com.example.recuu5.products


class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product: Product = products[args.id]
        binding.tvName.text = product.name
        binding.ivProduct.setImageResource(product.image)
        val priceDiscount = (product.price * product.discount) / 100
        val priceWithDiscount = (product.price - priceDiscount)
        if (product.discount == 0){
            binding.tvPriceDiscount.text = priceWithDiscount.round(2).toString() + "€"
            binding.iconDiscount.isVisible = false
        }else{
            binding.tvPrice.text = product.price.toString()
            binding.tvPriceDiscount.text = priceWithDiscount.round(2).toString() + "€"
            binding.tvPriceDiscount.setTextColor(Color.parseColor("#EF3232"))
            binding.iconDiscount.setColorFilter(Color.RED);
            binding.tvPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG)
        }
        if (product.stock == 0){
            binding.iconDispo.setColorFilter(Color.RED);
        }else{
            binding.iconDispo.setColorFilter(Color.GREEN);
        }

        binding.description.text = product.description
    }

    private fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}