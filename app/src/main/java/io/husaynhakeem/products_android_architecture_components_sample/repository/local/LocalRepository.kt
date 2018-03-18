package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product

class LocalRepository(private val productsDao: ProductsDao) {

    fun getProducts() = productsDao.getAllProducts()

    fun saveProducts(products: Array<Product>) = productsDao.saveProducts(products)
}