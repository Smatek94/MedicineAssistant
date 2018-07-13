package com.skolimowskim.medicineassistant.view.calendar.adapter

import android.view.View
import com.skolimowskim.medicineassistant.model.BaseHeader
import com.skolimowskim.medicineassistant.utils.recycler.BaseViewHolder

class CalendarHeaderViewHolder(view: View) : BaseViewHolder<BaseHeader>(view) {

    private lateinit var calendarEntryHeader: BaseHeader

    init {

    }

    override fun populateData(data: BaseHeader) {
        this.calendarEntryHeader = data
    }
}