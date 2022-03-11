package com.example.recuu5

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.recuu5.model.Product

class App  : Application()  {

    val products: MutableList<Product> = mutableListOf(
        Product(0,"Hollyberry Matte Lip Kit",R.drawable.lip1,29.99,5,40,"My Matte Liquid Lipstick lets you create a gorgeous matte lip. The true matte formula glides on effortlessly and offers 8-hour wear without drying lips. Available in a wide range of shades, the highly pigmented formula is cruelty free and vegan",true),
        Product(1,"Ginger Matte Lip Kit ",R.drawable.lip2,29.99,10,30,"Define and coat lips with an even layer, using the doe foot applicator",true),
        Product(2,"True Brown K Matte Lip Kit",R.drawable.lip3,29.99,0,13,"94% agreed the formula does not feather on the lips",true),
        Product(3,"Queen Matte Lip Kit ",R.drawable.lip4,29.99,10,19,"100% agreed the formula is non-sticky.",true),
        Product(4,"Twenty Matte Lip Kit",R.drawable.lip5,29.99,50,4,"Vegan, Clean, Cruelty Free, Gluten Free, Light Vanilla Aroma",true),
        Product(5,"Dirty Peach Matte Lip Kit",R.drawable.lip6,29.99,10,0,"Instant-setting color payof",true),
        Product(6,"Kylie Matte Lip Kit ",R.drawable.lip7,29.99,10,2,"Long-lasting 8-hour wear",true),
        Product(7,"Candy K Matte Lip Kit ",R.drawable.lip8,29.99,5,10,"True-matte non-sticky finish",true),
        Product(8,"One Wish Matte Lip Kit ",R.drawable.lip9,29.99,15,19,"Define and coat lips with an even layer, using the doe foot applicator.",true),
        Product(9,"Autumn Matte Lip Kit ",R.drawable.lip10,29.99,0,8,"My Matte Lip Kit lets you create my long-lasting matte lip looks. This Matte Liquid Lipstick & Lip Liner duo is my perfect ready-to-go lip routine. Available in a wide range of shades, the kit's highly pigmented formulas are cruelty free and vegan.",true)
    )
}

private val Fragment.app: App
    get() = this.activity?.application as App

val Fragment.products
    get() = app.products