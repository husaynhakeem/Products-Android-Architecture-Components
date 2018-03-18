/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.husaynhakeem.products_android_architecture_components_sample.R
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.ProductImage
import io.husaynhakeem.products_android_architecture_components_sample.utilities.EMPTY
import io.husaynhakeem.products_android_architecture_components_sample.utilities.UNAVAILABLE
import kotlinx.android.synthetic.main.layout_products_item.view.*

class ProductsItemViewHolder(
        parent: ViewGroup,
        @LayoutRes itemViewLayoutId: Int
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(itemViewLayoutId, parent, false)) {

    fun render(product: Product) {
        renderProductImage(product.images)
        renderProductName(product.name)
        renderProductBrand(product.brand ?: EMPTY)
        renderProductSize(product.size ?: EMPTY)
    }

    private fun renderProductImage(images: List<ProductImage>) {
        if (!images.isEmpty())
            Picasso.get()
                    .load(images[0].url)
                    .placeholder(R.drawable.background_no_image)
                    .into(itemView.productsItemImageView)
    }

    private fun renderProductName(name: String) {
        itemView.productsItemNameTextView.text = name
    }

    private fun renderProductBrand(brand: String) {
        itemView.productsItemBrandTextView.text = itemView.context.getString(R.string.product_item_brand, if (brand.isBlank()) UNAVAILABLE else brand)
    }

    private fun renderProductSize(size: String) {
        itemView.productsItemSizeTextView.text = itemView.context.getString(R.string.product_item_size, if (size.isBlank()) UNAVAILABLE else size)
    }
}