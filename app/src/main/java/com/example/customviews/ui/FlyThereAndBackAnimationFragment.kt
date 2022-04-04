package com.example.customviews.ui

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.customviews.databinding.FragmentFlyThereAndBackAnimationBinding
import com.example.customviews.utils.BaseFragment

class FlyThereAndBackAnimationFragment : BaseFragment<FragmentFlyThereAndBackAnimationBinding>(FragmentFlyThereAndBackAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val animator = ValueAnimator.ofFloat(0f, -screenHeight)

            with(animator){
                addUpdateListener {
                    val value = it.animatedValue as Float
                    binding.rocket.translationY = value
                    binding.doge.translationY = value
                }

                repeatMode = ValueAnimator.REVERSE
                repeatCount = 2
                duration = 700L
                start()
            }
        }
    }
}