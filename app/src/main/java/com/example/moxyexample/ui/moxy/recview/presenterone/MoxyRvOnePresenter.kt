package com.example.moxyexample.ui.moxy.recview.presenterone

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.moxyexample.di.NAME_HOME_ANIMALS
import com.example.moxyexample.di.NAME_WILD_ANIMALS
import com.example.moxyexample.model.Animal
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