package com.shino72.exchangecal.client

import com.shino72.exchangecal.service.ExchangeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExchangeClient {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.koreaexim.go.kr/site/program/financial/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val exchangeService : ExchangeService by lazy { retrofit.create(ExchangeService::class.java) }

}