package com.example.customviews.ui

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.customviews.databinding.FragmentWithListenerAnimationBinding
import com.example.customviews.utils.BaseFragment

class WithListenerAnimationFragment : BaseFragment<FragmentWithListenerAnimationBinding>(FragmentWithListenerAnimationBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.root.setOnClickListener {
            val animator = ValueAnimator.ofFloat(0f, -screenHeight)

            animator.addUpdateListener {
                val value = it.animatedValue as Float
                binding.rocket.translationY = value
                binding.doge.translationY = value
            }

            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    Toast.makeText(requireContext(), "Doge took off", Toast.LENGTH_SHORT).show()
                }

                override fun onAnimationEnd(animation: Animator) {
                    Toast.makeText(requireContext(), "Doge is on the moon", Toast.LENGTH_SHORT).show()
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })

            animator.duration = 5000L
            animator.start()
        }
    }
}