package com.play1xbet.sports.betting.sports.mvvmart.local


import com.play1xbet.sports.betting.sports.mvvmart.local.response.DataDemo
import com.play1xbet.sports.betting.sports.mvvmart.local.response.ResponseModel_Consigner_Consignee
import com.play1xbet.sports.betting.sports.mvvmart.remote.retofit.NumberApi
import com.play1xbet.sports.betting.sports.mvvmart.utils.Result
import com.play1xbet.sports.betting.sports.mvvmart.utils.Status

class NumberRepo(private val numberApi: NumberApi) {
    suspend fun getNumberFact(): Result<DataDemo> {
        return try {
            val response = numberApi.getNumberFact()
            return Result(Status.SUCCESS, response.body(), null)
        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }
    }
}