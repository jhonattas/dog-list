package com.soucriador.dogceo.data

interface BreedDataSource {

    fun listAll(success : (List<Breed>) -> Unit, failure: () -> Unit)
}