package com.skolimowskim.medicineassistant.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skolimowskim.medicineassistant.viewModel.CalendarViewModel
import com.skolimowskim.medicineassistant.R
import com.skolimowskim.medicineassistant.utils.Utils
import io.reactivex.disposables.Disposable

class CalendarActivity : AppCompatActivity() {

    private val viewModel: CalendarViewModel = CalendarViewModel.getInstance() // todo change to inject from dagger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
    }

    override fun onStart() {
        super.onStart()
        getCalendar()
    }

    private var disposable: Disposable? = null

    private fun getCalendar() {
        Utils.dispose(disposable)
        disposable = viewModel.getCalendar()
                .doOnSubscribe {}
                .doFinally {}
                .subscribe({}, {})
    }
}
