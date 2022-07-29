package com.play1xbet.sports.betting.sports.mvvmart.remote.retofit


import com.play1xbet.sports.betting.sports.mvvmart.local.response.DataDemo
import com.play1xbet.sports.betting.sports.mvvmart.local.response.ResponseModel_Consigner_Consignee
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

const val BASE_URL="https://run.mocky.io/v3/"


//https://run.mocky.io/v3/78e0e91a-d0cc-4908-a629-efac194149e4
interface NumberApi {

    @GET("78907fbc-f9a7-4ab6-baeb-f6aec61b3e6e")
    suspend fun getNumberFact(

    ):Response<DataDemo>
}