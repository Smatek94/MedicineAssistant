package com.skolimowskim.medicineassistant.model

import io.reactivex.Observable
import java.util.*

class CalendarRepository {

    companion object { // fixme remove when dagger is added
        private var instance: CalendarRepository? = null

        fun getInstance() : CalendarRepository {
            if(instance == null) instance = CalendarRepository()
            return instance!!
        }
    }

    // todo get calendar from database
    fun getCalendar(): Observable<MedCalendar> {
        val medCalendar = MedCalendar()
        medCalendar.entries.add(BaseEntry(Medicine("test1"), Date(System.currentTimeMillis())))
        medCalendar.entries.add(BaseEntry(Medicine("test2"), Date(System.currentTimeMillis())))
        medCalendar.entries.add(BaseEntry(Medicine("test3"), Date(System.currentTimeMillis())))
        return Observable.just(medCalendar)
//        return Observable.just(MedCalendar())
    }
}