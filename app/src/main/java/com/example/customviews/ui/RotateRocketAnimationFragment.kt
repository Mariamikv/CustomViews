package com.example.customviews.ui

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.example.customviews.databinding.FragmentRotateRocketAnimationBinding
import com.example.customviews.utils.BaseFragment

class RotateRocketAnimationFragment : BaseFragment<FragmentRotateRocketAnimationBinding>(FragmentRotateRocketAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val valueAnimator = ValueAnimator.ofFloat(0f, 360f)

            with(valueAnimator){
                addUpdateListener {
                    val value = it.animatedValue as Float
                    binding.rocket.rotation = value
                }

                interpolator = LinearInterpolator()
                duration = DEFAULT_ANIMATION_DURATION
                start()
            }
        }
    }
}