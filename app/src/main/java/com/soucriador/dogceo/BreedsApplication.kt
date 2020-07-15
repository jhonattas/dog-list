package com.soucriador.dogceo

import android.app.Application
import com.soucriador.dogceo.di.breedsModule
import org.koin.android.ext.android.startKoin

class BreedsApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, breedsModule)

    }
}