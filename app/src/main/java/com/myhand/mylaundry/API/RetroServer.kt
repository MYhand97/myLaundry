package com.myhand.mylaundry.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroServer(){
    val baseURL: String = "http://192.168.42.209/laundry/"
    var retro: Retrofit? = null

    fun koneksiRetrofit(): Retrofit {
        if (retro == null) {
            retro = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseURL)
                .build()
        }
        return retro!!
    }
}