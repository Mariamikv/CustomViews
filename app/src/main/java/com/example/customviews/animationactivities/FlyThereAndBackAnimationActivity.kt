package com.example.customviews.animationactivities

import android.animation.ValueAnimator

class FlyThereAndBackAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    val animator = ValueAnimator.ofFloat(0f, -screenHeight)

    animator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
      doge.translationY = value
    }

    animator.repeatMode = ValueAnimator.REVERSE
    animator.repeatCount = 2
    animator.duration = 700L
    animator.start()
  }
}
