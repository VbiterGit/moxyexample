package com.example.budgetplanner.ui.moxy.image

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.budgetplanner.R
import com.example.budgetplanner.toolkit.MvpAppCompatFragment
import kotlinx.android.synthetic.main.layout_moxy_image.*
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

class MoxyImageFragment: MvpAppCompatFragment(R.layout.layout_moxy_image), MoxyImageView {
    /**
     * Инъекция экземпляра MoxyImagePresenter в View
     */
    @InjectPresenter
    lateinit var presenter: MoxyImagePresenter

    /**
     * Передаем параметр в MoxyImagePresenter при его инициализации, используется в связке с DI (Koin, Dagger и т.п.)
     */
    @ProvidePresenter
    fun providePresenter(): MoxyImagePresenter = get {
        parametersOf( 1)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_recolor.setOnClickListener {
            presenter.recolorImage()
        }
        btn_calc_sum.setOnClickListener {
            presenter.calcSum()
        }
    }

    override fun onInitImage() {
        iv_android.setImageResource(R.drawable.ic_start_load_image)
    }

    override fun onRecolorImage() {
        iv_android.setImageResource(R.drawable.ic_load_image)
    }

    override fun onCalcSum() {
        val term1 = if (term1.text.isEmpty()) 0 else term1.text.toString().toInt()
        val term2 = if (term2.text.isEmpty()) 0 else term2.text.toString().toInt()
        sum.text = term1.plus(term2).toString()
    }
}