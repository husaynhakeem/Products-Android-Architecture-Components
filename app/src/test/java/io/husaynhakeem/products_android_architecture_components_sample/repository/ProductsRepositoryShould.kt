/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository

import io.husaynhakeem.products_android_architecture_components_sample.repository.local.LocalRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.RemoteRepository
import io.husaynhakeem.products_android_architecture_components_sample.utilities.ConnectivityAgent
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.*
import java.util.concurrent.Executor


class ProductsRepositoryShould {

    private val connectivityAgent = mock(ConnectivityAgent::class.java)
    private val localRepository = mock(LocalRepository::class.java)
    private val remoteRepository = mock(RemoteRepository::class.java)
    private val executor = mock(Executor::class.java)

    private val productsRepository = ProductsRepository(
            connectivityAgent,
            localRepository,
            remoteRepository,
            executor
    )

    @Test
    fun returnLocalRepositoryProducts_whenInternetIsUnavailable() {
        given(connectivityAgent.isDeviceConnectedToInternet()).willReturn(false)

        productsRepository.getProducts()

        verify(localRepository).getProducts()
        verify(remoteRepository, never()).getProducts()
    }
}