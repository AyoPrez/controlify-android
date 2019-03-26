package com.ayoprez.controlify.di

import androidx.room.Room
import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.database.AppDatabase
import com.ayoprez.controlify.database.DatabaseManagerImpl
import com.ayoprez.controlify.database.IDatabaseManager
import com.ayoprez.controlify.presenter.MainPresenter
import com.ayoprez.controlify.presenter.ReceiverPresenter
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val controlifyAppModule = module {

    single {
        FormatTimeUtils()
    }

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "sessionsDB").build()
    }

    single { get<AppDatabase>().sessionDataDao() }

    single<IDatabaseManager> {
        DatabaseManagerImpl()
    }
    factory { ReceiverPresenter(get(), get()) }
    factory { MainPresenter(get()) }
}