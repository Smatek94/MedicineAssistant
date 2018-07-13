package com.skolimowskim.medicineassistant.view.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.skolimowskim.medicineassistant.viewModel.CalendarViewModel
import com.skolimowskim.medicineassistant.R
import com.skolimowskim.medicineassistant.model.MedCalendar
import com.skolimowskim.medicineassistant.utils.Utils
import com.skolimowskim.medicineassistant.view.calendar.adapter.CalendarAdapter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_calendar.*

class CalendarActivity : AppCompatActivity() {

    private val viewModel: CalendarViewModel = CalendarViewModel.getInstance() // todo change to inject from dagger
    private var disposable: Disposable? = null

    private lateinit var calendarAdapter: CalendarAdapter

    // *************************************************************************************************************

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarAdapter = CalendarAdapter(LayoutInflater.from(this))
        calendar_recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        calendar_recycler.adapter = calendarAdapter
    }

    override fun onStart() {
        super.onStart()
        getCalendar()
    }

    // *************************************************************************************************************

    private fun getCalendar() {
        Utils.dispose(disposable)
        disposable = viewModel.getCalendar()
                .doOnSubscribe { toggleLoading(true) }
                .doFinally { toggleLoading(false) }
                .subscribe( {getCalendarSuccess(it) }, { getCalendarError(it) })
    }

    private fun getCalendarSuccess(medCalendar: MedCalendar) {
        if(medCalendar.entries.size == 0){
            calendar_recycler.visibility = View.GONE
            calendar_text.visibility = View.VISIBLE
            calendar_text.text = getString(R.string.no_calendar_entries)
        } else {
            calendarAdapter.updateEntries(medCalendar.entries)
        }
    }

    private fun getCalendarError(it: Throwable) {
        TODO("not implemented")
    }

    private fun toggleLoading(isLoading: Boolean) {
        if(isLoading){
            loading_calendar.visibility = View.VISIBLE
            calendar_recycler.visibility = View.GONE
        } else {
            loading_calendar.visibility = View.GONE
            calendar_recycler.visibility = View.VISIBLE
        }
    }
}
