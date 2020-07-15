package com.soucriador.dogceo.di

import com.soucriador.dogceo.breeds.BreedsViewModel
import com.soucriador.dogceo.data.BreedDataSource
import com.soucriador.dogceo.data.BreedRepository
import com.soucriador.dogceo.data.remote.DogCeoApi
import com.soucriador.dogceo.data.remote.DogCeoDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BreedsModule = module {
    single { Retrofit.Builder().baseUrl("https://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build() }
    single { (get() as Retrofit).create(DogCeoApi::class.java) }

    single  ("api"){DogCeoDataSource(get())  as BreedDataSource }
    single("repository") { BreedRepository(get("api")) as BreedDataSource}
    viewModel { BreedsViewModel(get("repository"), androidApplication())}
}


/**
 * Module list
 */
val breedsModule = listOf(BreedsModule)
