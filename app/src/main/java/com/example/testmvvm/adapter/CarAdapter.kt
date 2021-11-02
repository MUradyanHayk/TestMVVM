package com.example.testmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testmvvm.R
import com.example.testmvvm.model.Car
import com.example.testmvvm.viewHolder.BaseViewHolder
import io.realm.RealmChangeListener
import io.realm.RealmResults
import java.lang.ref.WeakReference

interface CarAdapterDelegate {
    fun onItemClick(identifier: String)
}

class CarAdapter : RecyclerView.Adapter<BaseViewHolder>, RealmChangeListener<RealmResults<Car>> {
    var context: Context
    var delegate: WeakReference<CarAdapterDelegate>?
    var list: RealmResults<Car>?

    constructor(context: Context, delegate: WeakReference<CarAdapterDelegate>?, list: RealmResults<Car>?) : super() {
        this.context = context
        this.list = list
        this.delegate = delegate
        this.list?.addChangeListener(this)
    }

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

//        Glide.with(context).load(list[position].imgUrl).into(holder.imageView!!)
        holder.textView!!.text = list?.get(position)?.name ?: ""
        holder.itemView.setOnClickListener {
            delegate?.get()?.onItemClick(list?.get(position)?.identifier ?: "")
        }

    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onChange(t: RealmResults<Car>) {
        notifyDataSetChanged()
    }
}

