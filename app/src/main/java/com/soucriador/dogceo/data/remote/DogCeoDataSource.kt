package com.soucriador.dogceo.data.remote

import com.soucriador.dogceo.data.Breed
import com.soucriador.dogceo.data.BreedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogCeoDataSource(val dogCeoApi: DogCeoApi) : BreedDataSource {


    override fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit) {
        val call = dogCeoApi.listBreeds()
        call.enqueue(object : Callback<DogCeoResponse> {

            override fun onResponse(call: Call<DogCeoResponse>, response: Response<DogCeoResponse>) {
                if (response.isSuccessful) {
                    val breeds = mutableListOf<Breed>()
                    response.body()?.message?.forEach {
                        breeds.add(Breed(it))
                    }
                    success(breeds)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<DogCeoResponse>, t: Throwable?) {
                failure()
            }
        })

    }
}