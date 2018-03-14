package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import io.husaynhakeem.products_android_architecture_components_sample.repository.BaseRepository

class LocalRepository(private val productsDao: ProductsDao) : BaseRepository {

    override fun getProducts() = productsDao.getAllProducts()
}