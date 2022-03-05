package com.example.recuu5.model

import android.graphics.drawable.Drawable

data class Product(

    val id: Int,
    val name: String,
    val image: Int,
    val price: Int,
    val discount: Int,
    val stock: Int,
    val description: String,
    val available: Boolean

)
