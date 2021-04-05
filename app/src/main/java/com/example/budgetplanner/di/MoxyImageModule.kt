package com.example.budgetplanner.di

import com.example.budgetplanner.ui.moxy.image.MoxyImagePresenter
import org.koin.dsl.module

/**
 *
 * Фабрика для объектов типа MoxyImagePresenter
 */
val moxyImageModule = module {
    factory { (id: Int?) -> MoxyImagePresenter(id) }
}