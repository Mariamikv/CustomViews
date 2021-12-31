package com.example.customviews.utils

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<BD: ViewBinding>
    (private val inflate: Inflate<BD>): Fragment() {

    protected var screenHeight = 0f

    private var _binding:BD? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null){
            _binding = inflate.invoke(inflater,container,false)
            startCreating(inflater,container)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onResume() {
        super.onResume()

        val displayMetrics = DisplayMetrics()
        activity?.display?.getRealMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels.toFloat()
    }

    protected fun printToast(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    abstract fun startCreating(inflater: LayoutInflater, container: ViewGroup?)

    protected val DEFAULT_ANIMATION_DURATION = 2500L
}