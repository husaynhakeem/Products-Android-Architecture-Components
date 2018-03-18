/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import android.arch.persistence.room.TypeConverter

class ListTypeConverter {

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        var result = ""
        list.forEach { result += "$it," }
        return result.substringBeforeLast(",")
    }

    @TypeConverter
    fun fromStringToList(string: String): List<String> {
        val result = mutableListOf<String>()
        string.split(",").forEach { result.add(it) }
        return result
    }
}