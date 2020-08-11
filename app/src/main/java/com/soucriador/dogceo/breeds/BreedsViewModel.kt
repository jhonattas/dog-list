package com.soucriador.dogceo.breeds

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.soucriador.dogceo.R
import com.soucriador.dogceo.data.Breed
import com.soucriador.dogceo.data.BreedDataSource

class BreedsViewModel(private val repository: BreedDataSource, private val application: Application)  : ViewModel() {

    var breeds = MutableLiveData<MutableList<Breed>>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.postValue(items.toMutableList())
            if (items.isEmpty()) {
                message.set(application.getString(R.string.breed_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(application.getString(R.string.breed_failed))
            loadingVisibility.set(false)
        })
    }



}