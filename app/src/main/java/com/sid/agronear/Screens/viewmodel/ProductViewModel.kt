package com.sid.agronear.Screens.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.DataClasses.ProductResponse
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    var products by mutableStateOf<List<ProductResponse>>(emptyList())
        private set

    fun loadProducts() {
        viewModelScope.launch {
            products = RetrofitClient.api.getProducts()
        }
    }

    fun addToWishlist(productId: Long) {
        viewModelScope.launch {
            RetrofitClient.api.addToWishlist(productId)
        }
    }
}