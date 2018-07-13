package com.skolimowskim.medicineassistant.utils.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view)  {

    abstract fun populateData(data : T)
}