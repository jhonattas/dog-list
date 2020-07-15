package com.soucriador.dogceo.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface DogCeoApi{

    @GET("breeds/list/all")
    fun listBreeds(): Call<DogCeoResponse>

}