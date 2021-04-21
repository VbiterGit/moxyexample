package com.example.moxyexample.ui.viewmodel.recview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moxyexample.model.Animal

class RvViewModel: ViewModel() {
    private var homeAnimals: MutableList<Animal> = mutableListOf()
    private var wildAnimals: MutableList<Animal> = mutableListOf()
    val currentAnimals: MutableLiveData<List<Animal>> by lazy { initialHomeAnimals() }

    private fun initialHomeAnimals(): MutableLiveData<List<Animal>> {
        setHomeAnimals()
        return MutableLiveData(homeAnimals)
    }

    fun loadHomeAnimals(){
        setHomeAnimals()
        currentAnimals.value = homeAnimals
    }

    private fun setHomeAnimals() {
        if (homeAnimals.isEmpty()) {
            for (i in 1..RvFragment.COUNT_HOME_ANIMALS) {
                homeAnimals.add(Animal(i, "${RvFragment.HOME_ANIMAL} - $i"))
            }
        }
    }

    fun loadWildAnimals(){
        setWildAnimals()
        currentAnimals.value = wildAnimals
    }

    private fun setWildAnimals() {
        if (wildAnimals.isEmpty()) {
            for (i in 1..RvFragment.COUNT_WILD_ANIMALS) {
                wildAnimals.add(Animal(i, "${RvFragment.WILD_ANIMAL} - $i"))
            }
        }
    }


}