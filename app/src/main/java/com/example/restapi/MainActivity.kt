package com.example.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.adapter.DeviceAdapter
import com.example.restapi.apicall.ApiService
import com.example.restapi.data.Device
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//https://api.restful-api.dev/objects?id=3&id=5&id=10
class MainActivity : AppCompatActivity() {

    private val deviceList: ArrayList<Device> = ArrayList()
    lateinit var recyclerView: RecyclerView
    lateinit var deviceAdapter: DeviceAdapter


    /* val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
     val deviceAdapter = DeviceAdapter(deviceList) // deviceList is the list of devices you fetched*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        deviceAdapter = DeviceAdapter(deviceList)
        recyclerView.adapter = deviceAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        /*recyclerView.adapter = deviceAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/

        getDevice()

    }

    private fun getDevice() {
        GlobalScope.launch {
            try {
                val response = ApiService.retrofit.getDevices(listOf("3", "5", "10"))
                if (response.isSuccessful) {
                    val deviceList = response.body()

                    deviceAdapter.deviceList = deviceList ?: emptyList() // Update the adapter's data

                    deviceAdapter.notifyDataSetChanged()

                    Log.e("ApiService", "$deviceList")
                } else {
                    Log.e("ApiService error", "Response not successful: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("ApiService error", "${e.message}")
            }
        }
    }

}