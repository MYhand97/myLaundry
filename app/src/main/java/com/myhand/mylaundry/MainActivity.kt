package com.myhand.mylaundry

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.myhand.mylaundry.API.RequestDataAPI
import com.myhand.mylaundry.API.RetroServer
import com.myhand.mylaundry.adapter.MyAdapter
import com.myhand.mylaundry.models.DataModels
import com.myhand.mylaundry.models.ResponseModels
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView ?= null
    private var linearLayoutManager: LinearLayoutManager ?= null
    private var list: List<DataModels> ?= ArrayList()
    private var myAdapter: MyAdapter ?= null
    private var swipeRefreshLayout: SwipeRefreshLayout ?= null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = my_recycleview
        swipeRefreshLayout = swl_data
        progressBar = pb_data
        linearLayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = linearLayoutManager

        swipeRefreshLayout?.setOnRefreshListener {
            retrieveData()
            swipeRefreshLayout?.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }

    fun retrieveData() {
        progressBar?.visibility = View.VISIBLE
        val ardData: RequestDataAPI = RetroServer().koneksiRetrofit().create<RequestDataAPI>(
            RequestDataAPI::class.java
        )
        val tampilData: Call<ResponseModels> = ardData.ardRetrieveData()
        tampilData.enqueue(object : Callback<ResponseModels>{
            override fun onResponse(call: Call<ResponseModels>, response: Response<ResponseModels>) {
                var kode: Int? = response.body()?.kode
                var pesan: String? = response.body()?.pesan
                Toast.makeText(applicationContext, "$kode | $pesan", Toast.LENGTH_LONG).show()
                list = response.body()?.data

                myAdapter = MyAdapter(applicationContext, list!!)
                recyclerView?.adapter = myAdapter
                myAdapter!!.notifyDataSetChanged()
                progressBar?.visibility = View.INVISIBLE
            }
            override fun onFailure(call: Call<ResponseModels>, t: Throwable) {
                progressBar?.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, "Gagal Menghubungi Server : $t", Toast.LENGTH_LONG).show()
            }
        })
    }
}
