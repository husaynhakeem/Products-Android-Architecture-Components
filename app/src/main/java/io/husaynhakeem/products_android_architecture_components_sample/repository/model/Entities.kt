/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Product(
        @PrimaryKey @SerializedName("gtin14") val id: String,
        @SerializedName("brand_name") val brand: String,
        @SerializedName("name") val name: String,
        @SerializedName("size") val size: String,
        @SerializedName("images") val images: List<ProductImage>
)

@Entity
data class ProductImage(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @SerializedName("url") val url: String
)