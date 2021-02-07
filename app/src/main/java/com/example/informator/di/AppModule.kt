package com.example.informator.di

import com.example.informator.home.HomeViewModel
import com.example.informator.network.CatAPIRepository
import com.example.informator.network.RetrofitClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitClient().getCatAPIService() }
    single { CatAPIRepository(get()) }

    viewModel { HomeViewModel(get()) }
}