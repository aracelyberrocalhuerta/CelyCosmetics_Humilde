package com.example.recuu5

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.recuu5.model.Product

class App  : Application()  {

    val products: MutableList<Product> = mutableListOf(
        Product(0,"Cat 1",R.drawable.cat1,2,1,4,"jeje",true),
        Product(1,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(2,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(3,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(4,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(5,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(6,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(7,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(8,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(9,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),
        Product(10,"Cat 2",R.drawable.cat2,2,1,4,"jeje",true),

    )
}

private val Fragment.app: App
    get() = this.activity?.application as App

val Fragment.products
    get() = app.products