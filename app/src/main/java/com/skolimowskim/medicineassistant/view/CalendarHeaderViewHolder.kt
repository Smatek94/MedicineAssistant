package com.skolimowskim.medicineassistant.view

import android.view.View
import com.skolimowskim.medicineassistant.model.MedCalendarEntry
import com.skolimowskim.medicineassistant.model.MedCalendarHeader

class CalendarHeaderViewHolder(view: View) : BaseViewHolder<MedCalendarHeader>(view) {

    private lateinit var calendarEntryHeader: MedCalendarHeader

    init {

    }

    override fun populateData(data: MedCalendarHeader) {
        this.calendarEntryHeader = data
    }
}