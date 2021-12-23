package com.example.customviews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.customviews.databinding.FragmentHomeBinding
import com.example.customviews.utils.BaseFragment
import com.example.customviews.utils.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        with(binding){
            happyButton.setOnClickListener {
                emotionalFaceView.happinessState = Constants.HAPPY
            }
            sadButton.setOnClickListener {
                emotionalFaceView.happinessState = Constants.SAD
            }
        }
    }
}