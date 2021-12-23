package com.example.customviews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.customviews.databinding.FragmentHomeBinding
import com.example.customviews.utils.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        with(binding){

        }
    }
}