package com.skolimowskim.medicineassistant.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view)  {

    abstract fun populateData(data : T)
}