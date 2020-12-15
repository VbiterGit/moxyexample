package com.example.moxyexample.di

import com.example.moxyexample.ui.moxy.image.MoxyImagePresenter
import org.koin.dsl.module

/**
 *
 * Фабрика для объектов типа MoxyImagePresenter
 */
val moxyImageModule = module {
    factory { (id: Int?) -> MoxyImagePresenter(id) }
}