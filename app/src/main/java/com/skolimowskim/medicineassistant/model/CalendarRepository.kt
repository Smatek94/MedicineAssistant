package com.skolimowskim.medicineassistant.model

import io.reactivex.Observable

class CalendarRepository {

    companion object { // fixme remove when dagger is added
        private var instance: CalendarRepository? = null

        fun getInstance() : CalendarRepository {
            if(instance == null) instance = CalendarRepository()
            return instance!!
        }
    }

    fun getCalendar(): Observable<MedCalendar> {
        return Observable.just(MedCalendar()) // todo get calendar from database
    }
}