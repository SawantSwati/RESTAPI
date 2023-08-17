package com.example.restapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.R
import com.example.restapi.data.Device

class DeviceAdapter(var deviceList:List<Device>)
    :RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>(){


        inner class DeviceViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val txtId :TextView = itemView.findViewById(R.id.txtId)
            val txtName :TextView = itemView.findViewById(R.id.txtName)
            val txtColor:TextView = itemView.findViewById(R.id.txtColor)
            val txtCapacity :TextView = itemView.findViewById(R.id.txtCapacity)
            val txtPrice:TextView = itemView.findViewById(R.id.txtPrice)
            val txtScreeSize:TextView = itemView.findViewById(R.id.txtScreenSize)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_device,parent,false)

        return DeviceViewHolder(itemView)
    }

    override fun getItemCount() = deviceList.size

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {

        val currentItem = deviceList[position]

        holder.txtId.text = currentItem.id
        holder.txtName.text = currentItem.name
        holder.txtColor.text = currentItem.data["color"].toString()
        holder.txtCapacity.text = currentItem.data["capacity GB"].toString()
        holder.txtPrice.text = currentItem.data["price"].toString()
        holder.txtScreeSize.text = currentItem.data["Screen size"].toString()



    }


}