
package com.example.daggerdependancyinjectiondemo.helpers

import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import com.example.daggerdependancyinjectiondemo.R
import com.example.daggerdependancyinjectiondemo.ui.MessagesTextView
import java.util.prefs.Preferences
import javax.inject.Inject


class TextViewStyler @Inject constructor(
) {

    companion object {
        const val COLOR_THEME = 0
        const val COLOR_PRIMARY_ON_THEME = 1
        const val COLOR_SECONDARY_ON_THEME = 2
        const val COLOR_TERTIARY_ON_THEME = 3

        const val SIZE_PRIMARY = 0
        const val SIZE_SECONDARY = 1
        const val SIZE_TERTIARY = 2
        const val SIZE_TOOLBAR = 3
        const val SIZE_DIALOG = 4
        const val SIZE_EMOJI = 5

        fun applyEditModeAttributes(textView: TextView, attrs: AttributeSet?) {
            textView.run {
                var colorAttr = 0
                var textSizeAttr = 0

                when (this) {
                    is MessagesTextView -> context.obtainStyledAttributes(attrs, R.styleable.QkTextView)
                        .run {
                            colorAttr = getInt(R.styleable.QkTextView_textColor, -1)
                            textSizeAttr = getInt(R.styleable.QkTextView_textSize, -1)
                            recycle()
                        }


                    else -> return
                }
                setTextColor(
                    when (colorAttr) {
                        COLOR_PRIMARY_ON_THEME -> context.getColor(R.color.textcolor1)
                        COLOR_SECONDARY_ON_THEME -> context.getColor(R.color.textcolor2)
                        COLOR_TERTIARY_ON_THEME -> context.getColor(R.color.textcolor3)
                        else -> currentTextColor
                    }
                )

                textSize = when (textSizeAttr) {
                    SIZE_PRIMARY -> 16f
                    SIZE_SECONDARY -> 14f
                    SIZE_TERTIARY -> 12f
                    SIZE_TOOLBAR -> 20f
                    SIZE_DIALOG -> 18f
                    SIZE_EMOJI -> 32f
                    else -> textSize / paint.density
                }
            }
        }
    }





}