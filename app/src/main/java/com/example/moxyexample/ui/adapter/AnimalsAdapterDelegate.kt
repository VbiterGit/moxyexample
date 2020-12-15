package com.example.moxyexample.ui.adapter

import com.example.moxyexample.R
import com.example.moxyexample.model.Animal
import com.example.moxyexample.ui.nomoxy.recview.NoMoxyRvFragment.Companion.HOME
import com.example.moxyexample.ui.nomoxy.recview.NoMoxyRvFragment.Companion.WILD
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import kotlinx.android.synthetic.main.item_animal.*

fun animalsAdapterDelegate(itemClickListener: (Int) -> Unit) =
    adapterDelegateLayoutContainer<Animal, Animal>(R.layout.item_animal){
        containerView.setOnClickListener { itemClickListener(item.id) }

        bind {
            tvAnimalName.text = item.name
            if (item.name.contains(HOME)) tvAnimalName.setBackgroundColor(getColor(R.color.card_view_home))
            if (item.name.contains(WILD)) tvAnimalName.setBackgroundColor(getColor(R.color.card_view_wild))
        }
    }