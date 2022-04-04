package com.example.customviews.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customviews.databinding.FragmentLaunchAndSApinViewAnimationBinding
import com.example.customviews.utils.BaseFragment

class LaunchAndSApinViewAnimationFragment : BaseFragment<FragmentLaunchAndSApinViewAnimationBinding>(FragmentLaunchAndSApinViewAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight)

            positionAnimator.addUpdateListener {
                val value = it.animatedValue as Float
                binding.rocket.translationY = value
            }

            val rotationAnimator = ObjectAnimator.ofFloat(binding.rocket, "rotation", 0f, 180f)

            val animatorSet = AnimatorSet()
            with(animatorSet){
                play(positionAnimator).with(rotationAnimator)
                duration = DEFAULT_ANIMATION_DURATION
                start()
            }
        }
    }

}