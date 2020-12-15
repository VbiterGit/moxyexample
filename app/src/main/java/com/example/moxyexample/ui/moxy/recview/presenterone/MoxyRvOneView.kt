package com.example.moxyexample.ui.moxy.recview.presenterone

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.moxyexample.model.Animal

@StateStrategyType(AddToEndSingleStrategy::class)
interface MoxyRvOneView: MvpView {
    fun onLoadWildAnimals(wildAnimals: List<Animal>)

    fun onLoadHomeAnimals(homeAnimals: List<Animal>)
}