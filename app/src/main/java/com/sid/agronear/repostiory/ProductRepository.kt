package com.sid.agronear.repostiory

import com.sid.agronear.Api.ApiService
import com.sid.agronear.model.ProductDto

class ProductRepository(private val api: ApiService) {

    suspend fun getAllProducts(): List<ProductDto> {
        val res = api.getAllProducts()
        if (res.isSuccessful) return res.body() ?: emptyList()
        throw Exception("Failed to load products")
    }

    suspend fun getMyProducts(): List<ProductDto> {
        val res = api.getMyProducts()
        if (res.isSuccessful) return res.body() ?: emptyList()
        throw Exception("Failed to load my products")
    }



    suspend fun getProductById(id: Long): ProductDto {
        val res = api.getProductById(id)
        if (res.isSuccessful) return res.body()!!
        throw Exception("Product not found")
    }

    suspend fun addProduct(product: ProductDto) {
        val res = api.addProduct(product)
        if (!res.isSuccessful) throw Exception("Failed to add product")
    }

    suspend fun updateProduct(id: Long, product: ProductDto) {
        val res = api.updateProduct(id, product)
        if (!res.isSuccessful) throw Exception("Failed to update product")
    }

    suspend fun deleteProduct(id: Long) {
        val res = api.deleteProduct(id)
        if (!res.isSuccessful) throw Exception("Failed to delete product")
    }

}
