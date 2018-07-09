package com.example.lianyuzhang.newyorktimedemo.activity.item_decoration

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import com.example.lianyuzhang.newyorktimedemo.R
import android.support.v4.content.ContextCompat

/*
* Custom item divider
*/
class SimpleDividerItemDecoration constructor(
        private val context: Context
) : RecyclerView.ItemDecoration() {
    private var divider = ContextCompat.getDrawable(context,R.drawable.line_divider)

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        val left = parent!!.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight
            divider!!.setBounds(left, top, right, bottom)
            divider!!.draw(c)
        }
    }
}