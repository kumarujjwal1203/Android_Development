package com.example.custon_view
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatEditText

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    private var borderColor: Int = 0
    private var borderWidth: Float = 0f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)

        borderColor = typedArray.getColor(
            R.styleable.CustomEditText_borderColor,
            resources.getColor(android.R.color.holo_green_dark, null)
        )

        borderWidth = typedArray.getDimension(
            R.styleable.CustomEditText_borderWidth,
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2f, resources.displayMetrics)
        )

        typedArray.recycle()

        paint.color = borderColor
        paint.strokeWidth = borderWidth
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(
            0f + borderWidth / 2,
            0f + borderWidth / 2,
            width.toFloat() - borderWidth / 2,
            height.toFloat() - borderWidth / 2,
            paint
        )
    }
}
