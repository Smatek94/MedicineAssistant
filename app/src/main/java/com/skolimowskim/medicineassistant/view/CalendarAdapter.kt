package com.skolimowskim.medicineassistant.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skolimowskim.medicineassistant.R
import com.skolimowskim.medicineassistant.model.MedCalendarEntry
import com.skolimowskim.medicineassistant.model.MedCalendarHeader
import java.util.*

class CalendarAdapter(private val inflater: LayoutInflater) :
        RecyclerView.Adapter<BaseViewHolder<MedCalendarAdapterItem>>() {

    private val calendarEntries = ArrayList<MedCalendarAdapterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MedCalendarAdapterItem> {
        return if (viewType == CalendarItemType.ENTRY.ordinal) {
            val itemView = inflater.inflate(R.layout.item_calendar, parent, false)
            CalendarViewHolder(itemView) as BaseViewHolder<MedCalendarAdapterItem>
        } else {
            val itemView = inflater.inflate(R.layout.item_calendar_header, parent, false)
            CalendarHeaderViewHolder(itemView) as BaseViewHolder<MedCalendarAdapterItem>
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<MedCalendarAdapterItem>, position: Int) {
        holder.populateData(calendarEntries[position])
    }

    override fun getItemCount(): Int {
        return calendarEntries.size
    }

    override fun getItemViewType(position: Int): Int {
        val medCalendarAdapterItem = calendarEntries[position]
        if (medCalendarAdapterItem is MedCalendarEntry)
            return CalendarItemType.ENTRY.ordinal
        else if (medCalendarAdapterItem is MedCalendarHeader)
            return CalendarItemType.HEADER.ordinal
        return CalendarItemType.UNKNOWN.ordinal
    }

    // ****************************************************************************************************************************************

    fun updateEntries(calendarEntries: List<MedCalendarEntry>) {
        this.calendarEntries.clear()
        this.calendarEntries.addAll(calendarEntries)
        this.calendarEntries.add(MedCalendarHeader())
        notifyDataSetChanged()
    }

    fun isEmpty() = itemCount <= 0
}

