package com.example.moxyexample.ui.nomoxy.recview

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moxyexample.R
import com.example.moxyexample.ui.adapter.animalsAdapterDelegate
import com.example.moxyexample.model.Animal
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.layout_nomoxy_rv.*

class NoMoxyRvFragment: Fragment(R.layout.layout_nomoxy_rv) {
    private lateinit var animalAdapter: ListDelegationAdapter<List<Animal>>
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var homeAnimals: MutableList<Animal> = mutableListOf()
    private var wildAnimals: MutableList<Animal> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toolbar.apply {
            title = getString(R.string.animals_list)
            inflateMenu(R.menu.rv_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.load_wild_animals -> {
                        loadWildAnimals()
                    }
                    R.id.load_home_animals -> {
                        loadHomeAnimals()
                    }
                    else -> {
                        //todo
                    }
                }
                true
            }
        }

        initView()
        loadHomeAnimals()
    }

    private fun initView() {
        animalAdapter = ListDelegationAdapter( animalsAdapterDelegate(::itemClick) )
        linearLayoutManager = LinearLayoutManager(context)
        rv_animals.layoutManager = linearLayoutManager
        rv_animals.adapter = animalAdapter
    }

    private fun loadHomeAnimals(){
        initHomeAnimals()
        animalAdapter.items = homeAnimals
        animalAdapter.notifyDataSetChanged()
    }

    private fun loadWildAnimals() {
        initWildAnimals()
        animalAdapter.items = wildAnimals
        animalAdapter.notifyDataSetChanged()
    }

    private fun initHomeAnimals(){
        if (homeAnimals.isEmpty()) {
            for (i in 1..COUNT_HOME_ANIMALS) {
                homeAnimals.add(Animal(i, "$HOME_ANIMAL - $i"))
            }
        }
    }

    private fun initWildAnimals(){
        if (wildAnimals.isEmpty()) {
            for (i in 1..COUNT_WILD_ANIMALS) {
                wildAnimals.add(Animal(i, "$WILD_ANIMAL - $i"))
            }
        }
    }

    private fun itemClick(id: Int){
        //TODO something with animal
    }

    companion object {
        const val HOME_ANIMAL = "Домашний зверек"
        const val HOME = "Домашний"
        const val WILD_ANIMAL = "Дикий зверек"
        const val WILD = "Дикий"
        const val COUNT_HOME_ANIMALS = 30
        const val COUNT_WILD_ANIMALS = 50
    }
}