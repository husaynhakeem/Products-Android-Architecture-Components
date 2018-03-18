/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.husaynhakeem.products_android_architecture_components_sample.R
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import kotlinx.android.synthetic.main.layout_products_item.view.*

class ProductsItemViewHolder(
        parent: ViewGroup,
        @LayoutRes itemViewLayoutId: Int
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(itemViewLayoutId, parent, false)) {

    fun render(product: Product) {
        renderProductImage(product.images)
        renderProductName(product.name)
        renderProductBrand(product.brand)
        renderProductSize(product.size)
    }

    private fun renderProductImage(images: List<String>) {
        if (images.isEmpty())
            itemView.productsItemImageView.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_no_image))
        else
            Picasso.get().load(images[0]).into(itemView.productsItemImageView)
    }

    private fun renderProductName(name: String) {
        itemView.productsItemNameTextView.text = name
    }

    private fun renderProductBrand(brand: String) {
        itemView.productsItemBrandTextView.text = brand
    }

    private fun renderProductSize(size: String) {
        itemView.productsItemSizeTextView.text = size
    }
}