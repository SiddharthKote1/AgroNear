package com.sid.agronear.Screens.viewmodel

import com.sid.agronear.Api.RetrofitClient
import android.content.Context
import android.net.Uri
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.sid.agronear.Screens.viewmodel.FileUtils
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class AddProductViewModel : ViewModel() {

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun addProduct(
        context: Context,
        productName: String,
        price: String,
        imageUri: Uri,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null

                val file = FileUtils.getFileFromUri(context, imageUri)

                val imagePart = MultipartBody.Part.createFormData(
                    "image",
                    file.name,
                    RequestBody.create("image/*".toMediaTypeOrNull(), file)
                )

                RetrofitClient.api.addProduct(
                    productName = productName.toRequestBody("text/plain".toMediaTypeOrNull()),
                    productPrice = price.toRequestBody("text/plain".toMediaTypeOrNull()),
                    image = imagePart
                )

                onSuccess()

            } catch (e: Exception) {
                errorMessage = "Failed to add product"
            } finally {
                isLoading = false
            }
        }
    }
}
