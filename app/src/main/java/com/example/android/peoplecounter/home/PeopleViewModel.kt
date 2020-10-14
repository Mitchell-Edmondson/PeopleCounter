package com.example.android.peoplecounter.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.peoplecounter.Constant

class PeopleViewModel(application: Application) : AndroidViewModel(application){

    var _currentPeopleCounter = MutableLiveData<Int>()
    val currentPeopleCounter : LiveData<Int>
        get() = _currentPeopleCounter

    var _totalPeopleCounter = MutableLiveData<Int>()
    val totalPeopleCounter : LiveData<Int>
        get() = _totalPeopleCounter

    private val peopleModel = PeopleModel()

    fun addOnePerson() {
        _currentPeopleCounter.value = _currentPeopleCounter.value!!.plus(1)
        _totalPeopleCounter.value = _totalPeopleCounter.value!!.plus(1)
        peopleModel.updateCurrentandTotalPeopleCounter(getApplication(), _currentPeopleCounter.value!!,  _totalPeopleCounter.value!!)
    }

    fun subtractOnePerson() {
        _currentPeopleCounter.value = _currentPeopleCounter.value!!.minus(1)
        peopleModel.updateCurrentPeopleCounter(getApplication(), _currentPeopleCounter.value!!)
    }

    fun reset() {
        _currentPeopleCounter.value = Constant.DEFAULT_PEOPLE
        _totalPeopleCounter.value = Constant.DEFAULT_PEOPLE

        peopleModel.updateCurrentandTotalPeopleCounter(getApplication(),_currentPeopleCounter.value!!, _totalPeopleCounter.value!!)
    }

    fun checkLocalStorageOnStart() {
        _currentPeopleCounter.value = peopleModel.getCurrentPeopleCounter(getApplication())
        _totalPeopleCounter.value = peopleModel.getTotalPeopleCounter(getApplication())
    }

    fun reachedMaxCapacity(currentPeopleCount: Int): Boolean {
        return currentPeopleCount > Constant.MAX_STORE_CAPACITY
    }

    fun reachedEmptyCapacity(currentPeopleCount: Int): Boolean {
        return currentPeopleCount == 0
    }
}
