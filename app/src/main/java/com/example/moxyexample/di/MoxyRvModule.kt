package com.example.moxyexample.di

import com.example.moxyexample.ui.moxy.recview.presenterone.MoxyRvOnePresenter
import com.example.moxyexample.ui.moxy.recview.presentertwo.MoxyRvTwoPresenter
import org.koin.dsl.module

/**
 *
 * Фабрика для объектов типа MoxyRvOnePresenter, MoxyRvTwoPresenter
 */
val moxyRvModule = module {
    factory { (init: String) -> MoxyRvOnePresenter(init) }
    factory { MoxyRvTwoPresenter() }
}