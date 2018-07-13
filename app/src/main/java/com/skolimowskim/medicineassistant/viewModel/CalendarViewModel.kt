package com.skolimowskim.medicineassistant.viewModel

import com.skolimowskim.medicineassistant.model.CalendarRepository
import com.skolimowskim.medicineassistant.model.MedCalendar
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CalendarViewModel(private val repo: CalendarRepository) {

    companion object {

        private var instance: CalendarViewModel? = null
        fun getInstance(): CalendarViewModel {
            if (instance == null) instance = CalendarViewModel(CalendarRepository.getInstance())
            return instance!!
        }

    }

    fun getCalendar(): Observable<MedCalendar> {
        return repo.getCalendar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}
