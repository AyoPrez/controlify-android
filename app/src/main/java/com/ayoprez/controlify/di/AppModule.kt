package com.ayoprez.controlify.di

import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.database.DatabaseManagerImpl
import com.ayoprez.controlify.database.IDatabaseManager
import com.ayoprez.controlify.presenter.MainPresenter
import com.ayoprez.controlify.presenter.ReceiverPresenter
import org.koin.dsl.module

val controlifyAppModule = module {

    single<IDatabaseManager> {
        DatabaseManagerImpl()
    }

    single {
        FormatTimeUtils()
    }

    factory { ReceiverPresenter(get(), get()) }
    factory { MainPresenter(get()) }
}