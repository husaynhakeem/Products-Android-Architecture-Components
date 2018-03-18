/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.husaynhakeem.products_android_architecture_components_sample.R
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.Product

class ProductsAdapter : RecyclerView.Adapter<ProductsItemViewHolder>() {

    private val products: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductsItemViewHolder(parent, R.layout.layout_products_item)

    override fun onBindViewHolder(holder: ProductsItemViewHolder, position: Int) {
        holder.render(products[position])
    }

    override fun getItemCount() = products.size

    fun updateProducts(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}