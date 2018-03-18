/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.utilities

import android.content.Context
import android.net.ConnectivityManager


class ConnectivityAgent(private val context: Context) {

    fun isDeviceConnectedToInternet(): Boolean {
        val service = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = service.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}