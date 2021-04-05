package com.example.budgetplanner.ui.moxy.recview

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import com.example.budgetplanner.R
import com.example.budgetplanner.ui.adapter.animalsAdapterDelegate
import com.example.budgetplanner.model.Animal
import com.example.budgetplanner.toolkit.MvpAppCompatFragment
import com.example.budgetplanner.ui.moxy.recview.presenterone.MoxyRvOnePresenter
import com.example.budgetplanner.ui.moxy.recview.presenterone.MoxyRvOneView
import com.example.budgetplanner.ui.moxy.recview.presentertwo.MoxyRvTwoPresenter
import com.example.budgetplanner.ui.moxy.recview.presentertwo.MoxyRvTwoView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.layout_nomoxy_rv.*
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

/**
 *
 * Несколько View можно приаттачить к одному Presenter, к примеру добавить еще одну View типа MoxyRvOneView
 * после чего viewState из MoxyRvOnePresenter будет отправлять команды в оба фрагмента типа MoxyRvOneView.
 */

class MoxyRvOneFragment: MvpAppCompatFragment(R.layout.layout_moxy_rv), MoxyRvOneView, MoxyRvTwoView {
    /**
     * Инъекция экземпляра MoxyRvPresenter в View
     */
    @InjectPresenter
    lateinit var onePresenter: MoxyRvOnePresenter

    /**
     * Передаем параметр в MoxyRvPresenter при его инициализации, используется в связке с DI (Koin, Dagger и т.п.)
     */
    @ProvidePresenter
    fun provideOnePresenter(): MoxyRvOnePresenter = get { parametersOf( "Инициализация") }

    /**
     * И к View можно приатачить любое кол-во Presenter. Можно использовать для разделения логики, если Presenter становится слишком объемный.
     * Также это упрощает дальнейшее разделение экарана на 2 и более
     */
    @InjectPresenter
    lateinit var twoPresenter: MoxyRvTwoPresenter

    @ProvidePresenter
    fun provideTwoPresenter(): MoxyRvTwoPresenter = get()

    private lateinit var animalAdapter: ListDelegationAdapter<List<Animal>>
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toolbar.apply {
            title = getString(R.string.animals_list)
            inflateMenu(R.menu.rv_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.load_wild_animals -> {
                        onePresenter.loadWildAnimals()
                    }
                    R.id.load_home_animals -> {
                        onePresenter.loadHomeAnimals()
                    }
                }
                true
            }
        }

        initView()
    }

    private fun initView() {
        animalAdapter = ListDelegationAdapter( animalsAdapterDelegate(::itemClick) )
        linearLayoutManager = LinearLayoutManager(context)
        rv_animals.layoutManager = linearLayoutManager
        rv_animals.adapter = animalAdapter
    }

    override fun onLoadHomeAnimals(homeAnimals: List<Animal>){
        animalAdapter.items = homeAnimals
        animalAdapter.notifyDataSetChanged()
    }

    override fun onLoadWildAnimals(wildAnimals: List<Animal>) {
        animalAdapter.items = wildAnimals
        animalAdapter.notifyDataSetChanged()
    }

    private fun itemClick(id: Int){
        //TODO something with animal
    }
}