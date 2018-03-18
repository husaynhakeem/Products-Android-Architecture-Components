/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.content.Context
import android.os.CountDownTimer
import android.widget.TextView
import io.husaynhakeem.products_android_architecture_components_sample.R


class EmptyProductsMessagesTimer(
        context: Context,
        private val emptyMessageTextView: TextView
) : CountDownTimer(LOADING_MESSAGE_TOTAL_DURATION, LOADING_MESSAGE_INDIVIDUAL_DURATION) {

    private val MESSAGES = arrayOf(
            context.getString(R.string.products_empty_message_0),
            context.getString(R.string.products_empty_message_1),
            context.getString(R.string.products_empty_message_2),
            context.getString(R.string.products_empty_message_3)
    )

    private var index = 0

    override fun onTick(p0: Long) {
        index = if (index < MESSAGES.size - 1) index + 1 else 0
        emptyMessageTextView.text = MESSAGES[index]
    }

    override fun onFinish() {}

    companion object {
        private const val LOADING_MESSAGE_TOTAL_DURATION = Int.MAX_VALUE.toLong()
        private const val LOADING_MESSAGE_INDIVIDUAL_DURATION = 500L
    }
}