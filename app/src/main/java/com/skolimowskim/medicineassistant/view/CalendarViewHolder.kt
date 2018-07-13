package com.skolimowskim.medicineassistant.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.skolimowskim.medicineassistant.model.MedCalendarEntry

class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    //    private val photo: ImageView = view.findViewById(R.id.photo)
    //    private val name: TextView = view.findViewById(R.id.name_text)
    //    private val update: Button = view.findViewById(R.id.update_button)

    private lateinit var calendarEntry: MedCalendarEntry

    init {
        //        view.setOnClickListener { listener.onBabySelected(baby) }
        //        update.setOnClickListener { listener.onBabySelected(baby, true) }
    }

    // ****************************************************************************************************************************************

    fun populateData(calendarEntry: MedCalendarEntry) {
        this.calendarEntry = calendarEntry
        //        name.text = baby.name
        //        ViewUtils.loadAvatar(photo, baby.getAvatar()) // fixme added photo but not loading
    }
}