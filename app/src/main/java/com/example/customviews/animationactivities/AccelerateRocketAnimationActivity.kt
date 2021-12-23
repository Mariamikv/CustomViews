package com.example.customviews.animationactivities

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.view.animation.AccelerateInterpolator

@SuppressLint("Recycle")
class AccelerateRocketAnimationActivity : BaseAnimationActivity() {

  override fun onStartAnimation() {
    val valueAnimator = ValueAnimator.ofFloat(0f, -screenHeight)
    valueAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
    }

    valueAnimator.interpolator = AccelerateInterpolator(1.5f)
    valueAnimator.duration = DEFAULT_ANIMATION_DURATION
    valueAnimator.start()
  }
}
