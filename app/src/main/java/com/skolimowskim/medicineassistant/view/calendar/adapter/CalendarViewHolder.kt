package com.skolimowskim.medicineassistant.view.calendar.adapter

import android.view.View
import com.skolimowskim.medicineassistant.model.BaseEntry
import com.skolimowskim.medicineassistant.utils.recycler.BaseViewHolder

class CalendarViewHolder(view: View) : BaseViewHolder<BaseEntry>(view) {

    private lateinit var calendarEntry: BaseEntry

    init {

    }

    // ****************************************************************************************************************************************

    override fun populateData(calendarEntry: BaseEntry) {
        this.calendarEntry = calendarEntry
    }
}