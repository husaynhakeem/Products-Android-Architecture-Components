/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import junit.framework.Assert.assertEquals
import org.junit.Test


class ListTypeConverterShould {

    private val listTypeConverter = ListTypeConverter()

    @Test
    fun convertFromListToString() {
        val itemsAsString = listTypeConverter.fromListToString(ITEMS_AS_LIST)
        assertEquals(ITEMS_AS_STRING, itemsAsString)
    }

    @Test
    fun convertFromStringToList() {
        val itemsAsList = listTypeConverter.fromStringToList(ITEMS_AS_STRING)
        assertEquals(ITEMS_AS_LIST, itemsAsList)
    }

    companion object {
        private const val ITEMS_AS_STRING = "item1,item2,item3"
        private val ITEMS_AS_LIST = listOf("item1", "item2", "item3")
    }
}