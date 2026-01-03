package com.sid.agronear.Screens.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.DataClasses.ProductResponse
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {

    var product by mutableStateOf<ProductResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadProduct(productId: Long) {
        viewModelScope.launch {
            isLoading = true
            try {
                product = RetrofitClient.api.getProductById(productId)
            } catch (e: Exception) {
                product = null
            } finally {
                isLoading = false
            }
        }
    }
}
