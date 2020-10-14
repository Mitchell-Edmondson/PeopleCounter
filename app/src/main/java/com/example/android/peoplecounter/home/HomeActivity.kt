package com.example.android.peoplecounter.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.peoplecounter.R
import com.example.android.peoplecounter.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var peopleViewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        val binding  : ActivityHomeBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_home
        )
        peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        binding.peopleViewModel = peopleViewModel
        binding.lifecycleOwner = this
        peopleViewModel.currentPeopleCounter.observe(this, Observer {
            updateUI(it)
        })

        peopleViewModel.checkLocalStorageOnStart()
    }

    private fun updateUI(currentPeopleCount: Int) {
        if(peopleViewModel.reachedMaxCapacity(currentPeopleCount)){
            textview_current_people.setTextColor(Color.RED)
        }
        else{
            textview_current_people.setTextColor(Color.BLACK)
            if(peopleViewModel.reachedEmptyCapacity(currentPeopleCount)){
                button_minus.visibility = View.INVISIBLE
            }
            else{
                button_minus.visibility = View.VISIBLE
            }
        }
    }

}
