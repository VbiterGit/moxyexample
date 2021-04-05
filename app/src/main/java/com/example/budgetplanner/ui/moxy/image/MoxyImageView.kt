package com.example.budgetplanner.ui.moxy.image

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MoxyImageView: MvpView {
    @AddToEndSingle
    fun onInitImage()
    @AddToEndSingle
    fun onRecolorImage()
    @AddToEndSingle
    fun onCalcSum()
}