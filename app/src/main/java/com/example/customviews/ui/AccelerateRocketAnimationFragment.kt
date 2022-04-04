package com.example.customviews.ui

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import com.example.customviews.databinding.FragmentAccelerateRocketAnimationBinding
import com.example.customviews.utils.BaseFragment

class AccelerateRocketAnimationFragment : BaseFragment<FragmentAccelerateRocketAnimationBinding>(FragmentAccelerateRocketAnimationBinding::inflate){
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val valueAnimator = ValueAnimator.ofFloat(0f, -screenHeight)
            with(valueAnimator) {
                addUpdateListener {
                    val value = it.animatedValue as Float
                    binding.rocket.translationY = value
                }

                interpolator = AccelerateInterpolator(1.5f)
                duration = DEFAULT_ANIMATION_DURATION
                start()
            }
        }
    }
}