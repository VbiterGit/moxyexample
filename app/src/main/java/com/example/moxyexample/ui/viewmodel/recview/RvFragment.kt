package com.example.moxyexample.ui.viewmodel.recview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moxyexample.R
import com.example.moxyexample.model.Animal
import com.example.moxyexample.ui.adapter.animalsAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.layout_nomoxy_rv.*

class RvFragment: Fragment(R.layout.layout_nomoxy_rv) {
    private val animalsModel: RvViewModel by viewModels()

    private lateinit var animalAdapter: ListDelegationAdapter<List<Animal>>
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        loadCurrentAnimals()
    }

    private fun initView() {
        animalAdapter = ListDelegationAdapter( animalsAdapterDelegate(::itemClick) )
        linearLayoutManager = LinearLayoutManager(context)
        rv_animals.layoutManager = linearLayoutManager
        rv_animals.adapter = animalAdapter
    }

    private fun loadCurrentAnimals() {
        animalsModel.customLD.observe(
            viewLifecycleOwner,
            {val str = it}
        )

        animalsModel.currentAnimals.observe(
            viewLifecycleOwner,
            { animalAdapter.items = it }
        )
        animalAdapter.notifyDataSetChanged()
    }

    private fun loadHomeAnimals(){
        animalsModel.loadHomeAnimals()
        animalAdapter.notifyDataSetChanged()
    }

    private fun loadWildAnimals() {
        animalsModel.loadWildAnimals()
        animalAdapter.notifyDataSetChanged()
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