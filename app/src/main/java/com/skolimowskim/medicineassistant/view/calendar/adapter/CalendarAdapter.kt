package com.skolimowskim.medicineassistant.view.calendar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skolimowskim.medicineassistant.R
import com.skolimowskim.medicineassistant.model.BaseEntry
import com.skolimowskim.medicineassistant.model.BaseHeader
import com.skolimowskim.medicineassistant.model.CalendarItemType
import com.skolimowskim.medicineassistant.utils.recycler.BaseAdapterItem
import com.skolimowskim.medicineassistant.utils.recycler.BaseViewHolder
import java.util.*

class CalendarAdapter(private val inflater: LayoutInflater) :
        RecyclerView.Adapter<BaseViewHolder<BaseAdapterItem>>() {

    private val calendarEntries = ArrayList<BaseAdapterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseAdapterItem> {
        return if (viewType == CalendarItemType.ENTRY.ordinal) {
            val itemView = inflater.inflate(R.layout.item_calendar, parent, false)
            CalendarViewHolder(itemView) as BaseViewHolder<BaseAdapterItem>
        } else {
            val itemView = inflater.inflate(R.layout.item_calendar_header, parent, false)
            CalendarHeaderViewHolder(itemView) as BaseViewHolder<BaseAdapterItem>
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseAdapterItem>, position: Int) {
        holder.populateData(calendarEntries[position])
    }

    override fun getItemCount(): Int {
        return calendarEntries.size
    }

    override fun getItemViewType(position: Int): Int {
        val medCalendarAdapterItem = calendarEntries[position]
        if (medCalendarAdapterItem is BaseEntry)
            return CalendarItemType.ENTRY.ordinal
        else if (medCalendarAdapterItem is BaseHeader)
            return CalendarItemType.HEADER.ordinal
        return CalendarItemType.UNKNOWN.ordinal
    }

    // ****************************************************************************************************************************************

    fun updateEntries(calendarEntries: List<BaseEntry>) {
        this.calendarEntries.clear()
        this.calendarEntries.addAll(calendarEntries)
        this.calendarEntries.add(BaseHeader())
        notifyDataSetChanged()
    }

    fun isEmpty() = itemCount <= 0
}

