package com.example.moxyexample.toolkit.livedata

import androidx.lifecycle.LiveData

class CustomLiveData: LiveData<String>() {
    private val listener = { price: String ->
        value = price
    }

    override fun onActive() {
        super.onActive()

        updateData(listener)
    }

    private fun updateData(listener: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun onInactive() {
        super.onInactive()

        removeData(listener)
    }

    private fun removeData(listener: (String) -> Unit) {
        TODO("Not yet implemented")
    }

}