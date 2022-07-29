package com.play1xbet.sports.betting.sports.mvvmart.hilt

import com.play1xbet.sports.betting.sports.mvvmart.local.NumberRepo
import com.play1xbet.sports.betting.sports.mvvmart.remote.retofit.BASE_URL
import com.play1xbet.sports.betting.sports.mvvmart.remote.retofit.NumberApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NumberModule {

    @Provides
    @Singleton
    fun provideRetrofitInterface(): NumberApi {

        val logger: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(logger).build()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NumberApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(numberApi: NumberApi): NumberRepo {
        return NumberRepo(numberApi)
    }
}