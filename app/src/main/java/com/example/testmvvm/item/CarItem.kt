package com.example.testmvvm.item

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.testmvvm.extensions.dp

class CarItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    var imageView: ImageView? = null
    var textView: TextView? = null

    init {
        orientation = HORIZONTAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 120.dp)
        createImageView()
        createTextView()
    }

    private fun createTextView() {
        textView = TextView(context)
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        params.gravity = Gravity.CENTER
        textView?.layoutParams
        addView(textView)
    }

    private fun createImageView() {
        imageView = ImageView(context)
        val params = LayoutParams(120.dp, 120.dp)
        params.gravity = Gravity.CENTER
        imageView?.layoutParams
        addView(imageView)
    }
}