package com.hyzoka.kinomap.di

import com.hyzoka.kinomap.BuildConfig
import com.hyzoka.kinomap.datasources.VoitureDataSource
import com.hyzoka.kinomap.datasources.VoitureService
import com.hyzoka.kinomap.repo.VoitureRepository
import com.hyzoka.kinomap.viewmodel.VoitureViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    viewModel { VoitureViewModel(get()) }
    single { VoitureRepository(get()) }
    single { VoitureDataSource(get()) }
    single { provideRetrofit() }
    single { provideApiService(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit): VoitureService {
    return retrofit.create(VoitureService::class.java)
}