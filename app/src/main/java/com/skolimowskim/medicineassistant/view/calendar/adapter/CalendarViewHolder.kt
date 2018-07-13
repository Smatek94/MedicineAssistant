package com.skolimowskim.medicineassistant.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.skolimowskim.medicineassistant.model.MedCalendarEntry

class CalendarViewHolder(view: View) : BaseViewHolder<MedCalendarEntry>(view) {

    private lateinit var calendarEntry: MedCalendarEntry

    init {

    }

    // ****************************************************************************************************************************************

    override fun populateData(calendarEntry: MedCalendarEntry) {
        this.calendarEntry = calendarEntry
    }
}