package com.example.budgetplanner.ui.moxy.image

import moxy.InjectViewState
import moxy.MvpPresenter

/**
 * Привязка Presenter к ViewState
 */
@InjectViewState
class MoxyImagePresenter(
    private val id: Int?
): MvpPresenter<MoxyImageView>() {
    private var newId : Int? = null

    /**
     * Инициализация Presenter при первом attach View, сохраняем инициализирующее значение. При дальнейших attach Presenter к новым View, этот метод не выполняется.
     */
    override fun onFirstViewAttach() {
        newId = id
        viewState.onInitImage()
    }

    /**
     * Перекрашиваем картинку
     */
    fun recolorImage(){
        viewState.onRecolorImage()
    }

    /**
     * Пересчитываем сумму
     */
    fun calcSum() {
        viewState.onCalcSum()
    }
}