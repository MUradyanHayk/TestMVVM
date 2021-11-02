package com.example.testmvvm.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testmvvm.R

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView:ImageView? = null
    var textView:TextView? = null

    init {
        imageView = itemView.findViewById(R.id.image_view_id)
        textView = itemView.findViewById(R.id.name_text_view_id)
    }
}