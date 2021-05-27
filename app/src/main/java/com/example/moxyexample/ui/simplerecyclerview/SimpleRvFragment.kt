package com.example.moxyexample.ui.simplerecyclerview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moxyexample.R
import com.example.moxyexample.model.Animal
import com.example.moxyexample.ui.adapter.AnimalsSimpleAdapter
import com.example.moxyexample.ui.viewmodel.recview.RvFragment.Companion.COUNT_HOME_ANIMALS
import com.example.moxyexample.ui.viewmodel.recview.RvFragment.Companion.HOME_ANIMAL
import kotlinx.android.synthetic.main.layout_nomoxy_rv.*

class SimpleRvFragment: Fragment(R.layout.layout_nomoxy_rv) {
    lateinit var animalsSimpleAdapter: AnimalsSimpleAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var animals: MutableList<Animal>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        initAnimals()
    }

    private fun initRecycler() {
        linearLayoutManager = LinearLayoutManager(context)
        rv_animals.layoutManager = linearLayoutManager
        rv_animals.adapter = AnimalsSimpleAdapter(animals.toList(), ::foo)
    }

    private fun initAnimals() {
        if (animals.isEmpty()) {
            for (i in 1..COUNT_HOME_ANIMALS) {
                animals.add(Animal(i, "$HOME_ANIMAL - $i"))
            }
        }
        animalsSimpleAdapter.notifyDataSetChanged()
    }

    private fun foo(animal: Animal){}
}