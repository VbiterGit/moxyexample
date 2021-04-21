package com.example.moxyexample.di

import com.example.moxyexample.model.Animal
import com.example.moxyexample.ui.moxy.recview.presenterone.MoxyRvOnePresenter
import com.example.moxyexample.ui.moxy.recview.presentertwo.MoxyRvTwoPresenter
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 *
 * Фабрика для объектов типа MoxyRvOnePresenter, MoxyRvTwoPresenter, Model - List<Animal>
 */
const val HOME_ANIMAL = "Домашний зверек"
const val WILD_ANIMAL = "Дикий зверек"
const val COUNT_HOME_ANIMALS = 30
const val COUNT_WILD_ANIMALS = 50
const val NAME_HOME_ANIMALS = "homeAnimals"
const val NAME_WILD_ANIMALS = "wildAnimals"

val moxyRvModule = module {
    factory { (init: String) -> MoxyRvOnePresenter(init) }
    factory { MoxyRvTwoPresenter() }
    single( named(NAME_HOME_ANIMALS) ) { List(COUNT_HOME_ANIMALS) { Animal(it, "$HOME_ANIMAL - $it") } }
    single( named(NAME_WILD_ANIMALS) ) { List(COUNT_WILD_ANIMALS) { Animal(it, "$WILD_ANIMAL - $it") } }
}