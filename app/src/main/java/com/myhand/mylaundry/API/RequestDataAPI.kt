package com.myhand.mylaundry.API

import com.myhand.mylaundry.models.ResponseModels
import retrofit2.http.GET
import retrofit2.Call

interface RequestDataAPI {
    @GET("retrieve.php")
    fun ardRetrieveData(): Call<ResponseModels>
}