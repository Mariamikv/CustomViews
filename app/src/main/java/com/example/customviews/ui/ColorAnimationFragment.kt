package com.example.customviews.ui

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.customviews.R
import com.example.customviews.databinding.FragmentColorAnimationBinding
import com.example.customviews.utils.BaseFragment

class ColorAnimationFragment : BaseFragment<FragmentColorAnimationBinding>(FragmentColorAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val objectAnimator = ObjectAnimator.ofObject(binding.root, "backgroundColor", ArgbEvaluator(),
                ContextCompat.getColor(requireContext(), R.color.purple_200),
                ContextCompat.getColor(requireContext(), R.color.purple_700)
            )

            with(objectAnimator){
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                duration = DEFAULT_ANIMATION_DURATION
                start()
            }
        }
    }
}