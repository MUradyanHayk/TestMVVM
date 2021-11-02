package com.example.testmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmvvm.R
import com.example.testmvvm.item.CarItem
import com.example.testmvvm.model.Car
import com.example.testmvvm.viewHolder.BaseViewHolder
import java.lang.ref.WeakReference

interface CarAdapterDelegate {
    fun onItemClick(car: Car)
}

class CarAdapter(var context: Context, var delegate: WeakReference<CarAdapterDelegate>?, var list: MutableList<Car>) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
//        val item = CarItem(context)
        return BaseViewHolder(item)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        val itemView = holder.itemView as CarItem
//        Glide.with(context).load(list[position].imgUrl).into(itemView.imageView!!)
//        itemView.textView!!.text = list[position].name
//        itemView.setOnClickListener {
//            delegate?.get()?.onItemClick(list[position])
//        }

        Glide.with(context).load(list[position].imgUrl).into(holder.imageView!!)
        holder.textView!!.text = list[position].name
        holder.itemView.setOnClickListener {
            delegate?.get()?.onItemClick(list[position])
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

