package com.example.moxyexample.ui.moxy.image

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MoxyImageView: MvpView {
    fun onInitImage()
    fun onRecolorImage()
    fun onCalcSum()
}