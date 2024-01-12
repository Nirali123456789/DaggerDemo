package com.example.daggerdependancyinjectiondemo.ui

import android.content.Context
import android.util.AttributeSet
import androidx.emoji2.widget.EmojiTextView
import com.example.daggerdependancyinjectiondemo.helpers.TextViewStyler
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
open class MessagesTextView @JvmOverloads  constructor(
    context: Context, attrs: AttributeSet? = null,  defStyleAttr: Int = 0
) : EmojiTextView(context, attrs,defStyleAttr) {

    @Inject
    lateinit var textViewStyler: TextViewStyler
    var collapseEnabled: Boolean = false

    @Inject
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
    ) : this(context, attrs, defStyleAttr) {
    }

    init {
        if (!isInEditMode) {
        } else {
            TextViewStyler.applyEditModeAttributes(this, attrs)
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (collapseEnabled) {
            layout
                    ?.takeIf { layout -> layout.lineCount > 0 }
                    ?.let { layout -> layout.getEllipsisCount(layout.lineCount - 1) }
                    ?.takeIf { ellipsisCount -> ellipsisCount > 0 }
                    ?.let { ellipsisCount -> text.dropLast(ellipsisCount).lastIndexOf(',') }
                    ?.takeIf { lastComma -> lastComma >= 0 }
                    ?.let { lastComma ->
                        val remainingNames = text.drop(lastComma).count { c -> c == ',' }
                        text = "${text.take(lastComma)}, +$remainingNames"
                    }
        }
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
        setLinkTextColor(color)
    }

}