package com.example.customviews.animationactivities

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.view.animation.LinearInterpolator

@SuppressLint("Recycle")
class LaunchRocketValueAnimatorAnimationActivity : BaseAnimationActivity() {

  override fun onStartAnimation() {
    // ofFloat accepts the floating point numbers that’ll apply to the specified property of the animated object over time
    // starts with 0f and end -screenHeight
    val valueAnimator = ValueAnimator.ofFloat(0f, -screenHeight)

    //ValueAnimator calls this listener with every update to the animated value —  default delay of 10 ms.
    valueAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
    }
    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = DEFAULT_ANIMATION_DURATION

    valueAnimator.start()
  }
}
