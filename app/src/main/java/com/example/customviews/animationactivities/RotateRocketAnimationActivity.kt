package com.example.customviews.animationactivities

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.view.animation.LinearInterpolator

@SuppressLint("Recycle")
class RotateRocketAnimationActivity : BaseAnimationActivity() {

  override fun onStartAnimation() {
    //make a full turn
    val valueAnimator = ValueAnimator.ofFloat(0f, 360f)

    valueAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.rotation = value
    }

    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = DEFAULT_ANIMATION_DURATION
    valueAnimator.start()
  }
}
