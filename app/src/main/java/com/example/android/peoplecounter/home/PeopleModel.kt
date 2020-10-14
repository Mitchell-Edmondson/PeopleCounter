package com.example.android.peoplecounter.home

import android.app.Application
import android.content.Context
import com.example.android.peoplecounter.Constant

class PeopleModel {

    fun updateCurrentPeopleCounter(application: Application, currentPeopleCounter: Int) {
        application.getSharedPreferences(Constant.prefSharedPrefs, Context.MODE_PRIVATE)
            .edit()
            .putInt(Constant.prefCurrentPeople, currentPeopleCounter)
            .apply()
    }

    fun updateCurrentandTotalPeopleCounter(application: Application, currentPeopleCounter: Int, totalPeopleCounter: Int) {
        application.getSharedPreferences(Constant.prefSharedPrefs, Context.MODE_PRIVATE)
            .edit()
            .putInt(Constant.prefCurrentPeople, currentPeopleCounter)
            .putInt(Constant.prefTotalPeople, totalPeopleCounter)
            .apply()
    }

    fun getCurrentPeopleCounter(application: Application): Int? {
        application.getSharedPreferences(Constant.prefSharedPrefs, Context.MODE_PRIVATE).let {
             return it.getInt(Constant.prefCurrentPeople, Constant.DEFAULT_PEOPLE)
        }
    }

    fun getTotalPeopleCounter(application: Application): Int? {
        application.getSharedPreferences(Constant.prefSharedPrefs, Context.MODE_PRIVATE).let {
            return it.getInt(Constant.prefTotalPeople, Constant.DEFAULT_PEOPLE)
        }
    }

}
