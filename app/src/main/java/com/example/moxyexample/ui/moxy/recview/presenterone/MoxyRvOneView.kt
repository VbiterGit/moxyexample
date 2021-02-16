package com.example.moxyexample.ui.moxy.recview.presenterone

import moxy.MvpView
import com.example.moxyexample.model.Animal
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MoxyRvOneView: MvpView {
    @AddToEndSingle
    fun onLoadWildAnimals(wildAnimals: List<Animal>)
    @AddToEndSingle
    fun onLoadHomeAnimals(homeAnimals: List<Animal>)
}