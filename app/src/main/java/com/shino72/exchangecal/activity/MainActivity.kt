package com.shino72.exchangecal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shino72.exchangecal.R
import com.shino72.exchangecal.client.ExchangeClient
import com.shino72.exchangecal.model.Exchange
import com.shino72.exchangecal.service.ExchangeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getEx("20230117")
    }

    private fun getEx(date : String)
    {
        val ExchangeClient = ExchangeClient
        ExchangeClient.exchangeService.getRespos(date, "AP01").enqueue(object : Callback<List<Exchange>>{
            override fun onResponse(call: Call<List<Exchange>>, response: Response<List<Exchange>>) {

            }
            override fun onFailure(call: Call<List<Exchange>>, t: Throwable) {

            }
        })
    }
}