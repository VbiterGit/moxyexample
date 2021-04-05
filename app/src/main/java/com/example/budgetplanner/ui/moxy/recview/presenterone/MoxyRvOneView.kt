package com.example.budgetplanner.ui.moxy.recview.presenterone

import moxy.MvpView
import com.example.budgetplanner.model.Animal
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MoxyRvOneView: MvpView {
    @AddToEndSingle
    fun onLoadWildAnimals(wildAnimals: List<Animal>)
    @AddToEndSingle
    fun onLoadHomeAnimals(homeAnimals: List<Animal>)
}