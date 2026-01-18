package com.sid.agronear.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sid.agronear.Api.RetrofitClient
import com.sid.agronear.model.ProductDto
import com.sid.agronear.repostiory.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {


    private val _myProducts = MutableLiveData<List<ProductDto>>()
    val myProducts: LiveData<List<ProductDto>> = _myProducts

    private val _addSuccess = MutableLiveData<Boolean>()
    val addSuccess: LiveData<Boolean> = _addSuccess

    private val api = RetrofitClient.create(getApplication())
    private val repo = ProductRepository(api)

    private val _products = MutableLiveData<List<ProductDto>>()
    val products: LiveData<List<ProductDto>> = _products

    // 🔹 Single product
    private val _selectedProduct = MutableLiveData<ProductDto>()
    val selectedProduct: LiveData<ProductDto> = _selectedProduct

    // 🔹 Wishlist
    private val _wishlist = MutableLiveData<List<ProductDto>>()
    val wishlist: LiveData<List<ProductDto>> = _wishlist

    // 🔹 UI state
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error


    fun loadProducts() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _products.value = repo.getAllProducts()
            } catch (e: Exception) {
                _error.value = e.message
            }
            _loading.value = false
        }
    }

    fun loadProduct(id: Long) {
        viewModelScope.launch {
            try {
                _selectedProduct.value = repo.getProductById(id)
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun loadMyProducts() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _myProducts.value = repo.getMyProducts()
            } catch (e: Exception) {
                _error.value = e.message
            }
            _loading.value = false
        }
    }

    fun addProduct(product: ProductDto) {
        viewModelScope.launch {
            try {
                repo.addProduct(product)
                _addSuccess.value = true
                Log.d("ADD_PRODUCT", "addSuccess set to TRUE") // 👈 ADD THIS
                loadProducts()
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("ADD_PRODUCT", "Error: ${e.message}")
            }
        }
    }

    fun updateProduct(id: Long, product: ProductDto) {
        viewModelScope.launch {
            try {
                repo.updateProduct(id, product)
                loadProducts()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun deleteProduct(id: Long) {
        viewModelScope.launch {
            try {
                repo.deleteProduct(id)
                loadProducts()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}
