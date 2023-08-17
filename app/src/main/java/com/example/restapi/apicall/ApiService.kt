package com.example.restapi.apicall

import com.example.restapi.data.Device
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("objects")
    suspend fun getDevices(@Query("id") ids: List<String>): Response<List<Device>>


    companion object {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.restful-api.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}