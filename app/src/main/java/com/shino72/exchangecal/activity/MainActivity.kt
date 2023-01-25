package com.shino72.exchangecal.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shino72.exchangecal.R
import com.shino72.exchangecal.client.ExchangeClient
import com.shino72.exchangecal.data.MyApplication
import com.shino72.exchangecal.databinding.ActivityMainBinding
import com.shino72.exchangecal.model.Exchange
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.round

class MainActivity : BaseActivity<ActivityMainBinding>(){
    override var layoutResourceId: Int = R.layout.activity_main
    private lateinit var mainViewModel: MainViewModel
    var money = "KRW"
    override fun initBinding() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainLayout = mainViewModel

        setDate()

        mainViewModel.text.observe(this, Observer {
            binding.tvTop.text = it.toString()
            if(it.toString() != "") {
                val cal = it.toDouble() * MyApplication.prefs.getString(money + " deal","0").toDouble()
                val sCal = (round(cal*100) / 100)
                binding.tvBottom.text = String.format("%1$,.2f", sCal)
            }
            else binding.tvBottom.text = ""
        })
        binding.dropdownMoney.setItemClickListener{ i, item ->
            money = item.text
            binding.tvStatusTop.text = MyApplication.prefs.getString(money + " unit","null")
            if(binding.tvTop.text.toString() != "") {
                val cal = binding.tvTop.text.toString().toDouble() * MyApplication.prefs.getString(money + " deal","0").toDouble()
                val sCal = (round(cal*100) / 100)
                binding.tvBottom.text = String.format("%1$,.2f", sCal)
            }
        }
    }
    private fun setDate()
    {
        val now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        if(MyApplication.prefs.getDate() == now) {
            MyApplication.prefs.setDate(now)
            getEx(now)
        }
    }
    private fun getEx(date : String)
    {
        val exchangeClient = ExchangeClient
        exchangeClient.exchangeService.getRespos(date, "AP01").enqueue(object : Callback<List<Exchange>>{
            override fun onResponse(call: Call<List<Exchange>>, response: Response<List<Exchange>>) {
                response.body()!!.forEach { it ->
                    MyApplication.prefs.setString(it.name.toString() + " unit", it.unit.toString())
                    val deal = it.deal!!.replace(",","")
                    MyApplication.prefs.setString(it.name.toString() + " deal", deal)
                }
            }
            override fun onFailure(call: Call<List<Exchange>>, t: Throwable) {
            }
        })
    }
}