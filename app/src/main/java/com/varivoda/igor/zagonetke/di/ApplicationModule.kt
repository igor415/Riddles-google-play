package com.varivoda.igor.zagonetke.di

import com.varivoda.igor.zagonetke.ui.levels.LevelsViewModel
import com.varivoda.igor.zagonetke.ui.riddle.RiddleViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        RiddleViewModel(
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    viewModel { LevelsViewModel(get(), get()) }
}