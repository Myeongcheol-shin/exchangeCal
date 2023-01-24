package com.shino72.exchangecal.service

import com.shino72.exchangecal.key.API_KEY
import com.shino72.exchangecal.model.Exchange
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeService {
    @GET("exchangeJSON?authkey=${API_KEY.API_KEY}")
    fun getRespos(
        @Query("searchdate") searchdate : String,
        @Query("data") data : String,
    ) : Call<List<Exchange>>
}