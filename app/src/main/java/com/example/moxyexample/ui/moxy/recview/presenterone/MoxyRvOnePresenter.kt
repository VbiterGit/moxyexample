package com.example.moxyexample.ui.moxy.recview.presenterone

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.moxyexample.model.Animal

@InjectViewState
class MoxyRvOnePresenter(
    private val initString: String?
): MvpPresenter<MoxyRvOneView>() {
    private lateinit var newString: String
    private var homeAnimals: MutableList<Animal> = mutableListOf()
    private var wildAnimals: MutableList<Animal> = mutableListOf()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        newString = initString ?: ""
    }


    fun loadWildAnimals(){
        initWildAnimals()
        viewState.onLoadWildAnimals(wildAnimals.toList())
    }

    fun loadHomeAnimals(){
        initHomeAnimals()
        viewState.onLoadHomeAnimals(homeAnimals.toList())
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

    companion object {
        const val HOME_ANIMAL = "Домашний зверек"
        const val WILD_ANIMAL = "Дикий зверек"
        const val COUNT_HOME_ANIMALS = 30
        const val COUNT_WILD_ANIMALS = 50
    }
}