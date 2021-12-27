package com.example.customviews.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customviews.databinding.FragmentLaunchRockerObjectAnimationBinding
import com.example.customviews.utils.BaseFragment


class LaunchRockerObjectAnimationFragment : BaseFragment<FragmentLaunchRockerObjectAnimationBinding>(FragmentLaunchRockerObjectAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val objectAnimator = ObjectAnimator.ofFloat(binding.rocket, "translationY", 0f, -screenHeight)

            objectAnimator.duration = DEFAULT_ANIMATION_DURATION
            objectAnimator.start()
        }
    }

}