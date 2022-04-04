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

            with(animator){
                addUpdateListener {
                    val value = it.animatedValue as Float
                    binding.rocket.translationY = value
                    binding.doge.translationY = value
                }

                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {
                        printToast("Doge took off")
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        printToast("print toast")
                    }

                    override fun onAnimationCancel(animation: Animator) {
                    }

                    override fun onAnimationRepeat(animation: Animator) {
                    }
                })

                duration = 5000L
                start()
            }
        }
    }
}