package com.example.moxyexample.ui.viewmodel.recview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moxyexample.model.Animal
import com.example.moxyexample.toolkit.livedata.CustomLiveData
import org.koin.core.KoinComponent
import org.koin.core.inject

class RvViewModel: ViewModel(), KoinComponent {
    private var homeAnimals: MutableList<Animal> = mutableListOf()
    private var wildAnimals: MutableList<Animal> = mutableListOf()
    val currentAnimals: MutableLiveData<List<Animal>> by lazy { initialHomeAnimals() }
    val customLD: CustomLiveData by inject()

    private fun initialHomeAnimals(): MutableLiveData<List<Animal>> {
        setHomeAnimals()

        val testAnimals: LiveData<List<Animal>> = Transformations.switchMap(currentAnimals){
            doSomeTransformations(it)
        }
        return MutableLiveData(testAnimals.value)
    }

    private fun doSomeTransformations(currentAnimals: List<Animal>?): LiveData<List<Animal>> {
        return MutableLiveData(currentAnimals)
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