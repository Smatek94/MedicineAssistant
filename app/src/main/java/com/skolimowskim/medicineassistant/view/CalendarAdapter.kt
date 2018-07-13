package com.skolimowskim.medicineassistant.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skolimowskim.medicineassistant.R
import com.skolimowskim.medicineassistant.model.MedCalendarEntry
import java.util.ArrayList

class CalendarAdapter(private val inflater: LayoutInflater) :
        RecyclerView.Adapter<CalendarViewHolder>() {

    private val calendarEntries = ArrayList<MedCalendarEntry>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val itemView = inflater.inflate(R.layout.item_calendar, parent, false)
        return CalendarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.populateData(calendarEntries[position])
    }

    override fun getItemCount(): Int {
        return calendarEntries.size
    }

    // ****************************************************************************************************************************************

    fun updateEntries(calendarEntries: List<MedCalendarEntry>) {
        this.calendarEntries.clear()
        this.calendarEntries.addAll(calendarEntries)
        notifyDataSetChanged()
    }

    fun isEmpty() = itemCount <= 0
}

