package com.skolimowskim.medicineassistant.utils

import io.reactivex.disposables.Disposable

object Utils {

    fun dispose(disposable: Disposable?){
        if(disposable != null && !disposable.isDisposed){
            disposable.dispose()
        }
    }

}