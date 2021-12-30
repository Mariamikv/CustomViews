package com.example.customviews.ui

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.customviews.databinding.FragmentFlyWithDogeAnimationBinding
import com.example.customviews.utils.BaseFragment

class FlyWithDogeAnimationFragment : BaseFragment<FragmentFlyWithDogeAnimationBinding>(FragmentFlyWithDogeAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight)
            positionAnimator.addUpdateListener {
                val value = it.animatedValue as Float
                binding.rocket.translationY = value
                binding.doge.translationY = value
            }

            val rotationAnimator = ValueAnimator.ofFloat(0f, 360f)
            rotationAnimator.addUpdateListener {
                val value = it.animatedValue as Float
                binding.doge.rotation = value
            }

            val animatorSet = AnimatorSet()
            with(animatorSet){
                play(positionAnimator).with(rotationAnimator)
                duration = DEFAULT_ANIMATION_DURATION
                start()
            }
        }
    }
}