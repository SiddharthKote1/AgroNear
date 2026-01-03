package com.sid.agronear.Screens.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.DataClasses.WishlistResponse
import kotlinx.coroutines.launch

class WishlistViewModel : ViewModel() {

    var wishlist by mutableStateOf<List<WishlistResponse>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadWishlist() {
        viewModelScope.launch {
            isLoading = true
            try {
                wishlist = RetrofitClient.api.getWishlist()
            } catch (e: Exception) {
                wishlist = emptyList()
            } finally {
                isLoading = false
            }
        }
    }

    fun removeFromWishlist(productId: Long) {
        viewModelScope.launch {
            RetrofitClient.api.removeFromWishlist(productId)
            loadWishlist()
        }
    }
}
