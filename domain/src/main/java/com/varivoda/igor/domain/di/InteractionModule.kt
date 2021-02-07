package com.varivoda.igor.domain.di

import com.varivoda.igor.domain.interactors.*
import org.koin.dsl.module

val interactionModule = module {

    single { GetAllRiddles(get()) }

    single { GetPoints(get()) }

    single { InsertPoints(get()) }

    single { GetQuestionId(get()) }

    single { ResetPoints(get()) }

    single { SubtractFromScore(get()) }

    single { GetRiddlesForCategory(get()) }
}