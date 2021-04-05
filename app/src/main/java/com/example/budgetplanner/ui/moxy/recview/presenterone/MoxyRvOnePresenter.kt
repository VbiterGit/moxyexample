package com.example.budgetplanner.ui.moxy.recview.presenterone

import moxy.InjectViewState
import moxy.MvpPresenter
import com.example.budgetplanner.di.NAME_HOME_ANIMALS
import com.example.budgetplanner.di.NAME_WILD_ANIMALS
import com.example.budgetplanner.model.Animal
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.qualifier.named

@InjectViewState
class MoxyRvOnePresenter(
    private val initString: String?
): MvpPresenter<MoxyRvOneView>(), KoinComponent {
    private lateinit var newString: String

    /**
     * Здесь объекты Model инжектятся напрямую в Presenter.
     * Можно также добавить ассинхронные вызовы через Interactor, Repository подгружающие данные из сети/БД, результаты которых через viewState этого Presenter будут менять состояние View
     */
    private val homeAnimals: List<Animal> = get(named(NAME_HOME_ANIMALS))
    private val wildAnimals: List<Animal> = get(named(NAME_WILD_ANIMALS))

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        newString = initString ?: ""
    }

    fun loadWildAnimals(){
        viewState.onLoadWildAnimals(wildAnimals)
    }

    fun loadHomeAnimals(){
        viewState.onLoadHomeAnimals(homeAnimals)
    }
}