package com.example.customviews.customviews

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.customviews.R
import com.example.customviews.utils.Constants
import com.example.customviews.utils.Constants.Companion.DEFAULT_BORDER_COLOR
import com.example.customviews.utils.Constants.Companion.DEFAULT_BORDER_WIDTH
import com.example.customviews.utils.Constants.Companion.DEFAULT_EYES_COLOR
import com.example.customviews.utils.Constants.Companion.DEFAULT_FACE_COLOR
import com.example.customviews.utils.Constants.Companion.DEFAULT_MOUTH_COLOR
import com.example.customviews.utils.Constants.Companion.HAPPY

class EmotionalFaceView(context: Context, attrs: AttributeSet) : View(context, attrs){

    private var faceColor = DEFAULT_FACE_COLOR
    private var eyesColor = DEFAULT_EYES_COLOR
    private var mouthColor = DEFAULT_MOUTH_COLOR
    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH

    private val paint = Paint()
    private val mouthPath = Path()
    private var size = 0

    private lateinit var leftEye: ShapeDrawable
    private lateinit var rightEye: ShapeDrawable

    var happinessState = HAPPY
        set(state) {
            field = state
            invalidate()
        }

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.EmotionalFaceView, 0, 0)

        happinessState = typedArray.getInt(R.styleable.EmotionalFaceView_state, HAPPY.toInt()).toLong()
        faceColor = typedArray.getColor(R.styleable.EmotionalFaceView_faceColor, DEFAULT_FACE_COLOR)
        eyesColor = typedArray.getColor(R.styleable.EmotionalFaceView_eyesColor, DEFAULT_EYES_COLOR)
        mouthColor = typedArray.getColor(R.styleable.EmotionalFaceView_mouthColor, DEFAULT_MOUTH_COLOR)
        borderColor = typedArray.getColor(R.styleable.EmotionalFaceView_borderColor, DEFAULT_BORDER_COLOR)
        borderWidth = typedArray.getDimension(R.styleable.EmotionalFaceView_borderWidth, DEFAULT_BORDER_WIDTH)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFaceBackground(canvas: Canvas){
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size/2f
        canvas.drawCircle(size/2f, size/2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas.drawCircle(size/2f, size/2f, radius-borderWidth/2f, paint)
    }

    private fun drawEyes(canvas: Canvas){

        // (32%, 23%, 43%, 50%)
        leftEye = ShapeDrawable(OvalShape())
        leftEye.setBounds((size * 0.32f).toInt(), (size * 0.23f).toInt(), (size * 0.43f).toInt(), (size * 0.50f).toInt())
        leftEye.paint.color = eyesColor
        leftEye.draw(canvas)

        //(57%, 23%, 68%, 50%)
        rightEye = ShapeDrawable(OvalShape())
        rightEye.setBounds((size * 0.57f).toInt(), (size * 0.23f).toInt(), (size * 0.68f).toInt(), (size * 0.50f).toInt())
        rightEye.paint.color = eyesColor
        rightEye.draw(canvas)
    }

    private fun drawMouth(canvas: Canvas){
        mouthPath.reset()
        mouthPath.moveTo(size * 0.22f, size * 0.7f)
        if (happinessState == HAPPY) {
            mouthPath.quadTo(size * 0.5f, size * 0.80f, size * 0.78f, size * 0.7f)
            mouthPath.quadTo(size * 0.5f, size * 0.90f, size * 0.22f, size * 0.7f)
        } else {
            mouthPath.quadTo(size * 0.5f, size * 0.50f, size * 0.78f, size * 0.7f)
            mouthPath.quadTo(size * 0.5f, size * 0.60f, size * 0.22f, size * 0.7f)
        }
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas.drawPath(mouthPath, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle()
        bundle.putLong("happinessState", happinessState)
        bundle.putParcelable("superState", super.onSaveInstanceState())
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        var viewState = state
        if (viewState is Bundle) {
            happinessState = viewState.getLong("happinessState", HAPPY)
            viewState = viewState.getParcelable("superState")!!
        }
        super.onRestoreInstanceState(viewState)
    }
}