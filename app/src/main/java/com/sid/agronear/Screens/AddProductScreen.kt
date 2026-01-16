package com.sid.agronear.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sid.agronear.Routes
import com.sid.agronear.model.ProductDto
import com.sid.agronear.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavController) {

    // 🔹 ViewModel + Context
    val viewModel: ProductViewModel = viewModel()
    val context = LocalContext.current

    // 🔹 UI States
    var productName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("Vegetable") }
    var quantity by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val addSuccess by viewModel.addSuccess.observeAsState()



    LaunchedEffect(addSuccess) {
        if (addSuccess == true) {
            navController.navigate(Routes.MainAppScreen) {
                popUpTo(Routes.AddProductScreen) { inclusive = true }
            }
        }
    }



    // 🔹 Image Picker
    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->
            imageUri = uri
        }

    val screenColor = Color(0xFFE8F5E9)
    val cardColor = Color(0xFFF1F8F4)
    val accentGreen = Color(0xFF5C8D4E)

    Scaffold(
        containerColor = screenColor,
        topBar = {
            TopAppBar(
                title = { Text("Add Product") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = screenColor
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(cardColor, RoundedCornerShape(20.dp))
                    .padding(16.dp)
            ) {

                // ---------- Add Photo ----------
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.CenterHorizontally)
                        .border(
                            BorderStroke(1.dp, Color(0xFFB7D7C2)),
                            RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            imagePickerLauncher.launch("image/*")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (imageUri == null) "Add Photo" else "Photo Selected",
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // ---------- Product Name ----------
                Text("Product Name")
                OutlinedTextField(
                    value = productName,
                    onValueChange = { productName = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // ---------- Category ----------
                Text("Quantity (kg)")
                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // ---------- Price ----------
                Text("Price per kg")
                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // ---------- Description ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Description")
                    Text("${description.length}/500", color = Color.Gray)
                }

                OutlinedTextField(
                    value = description,
                    onValueChange = {
                        if (it.length <= 500) description = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    maxLines = 5
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (
                            //imageUri != null &&
                            productName.isNotBlank() &&
                            price.isNotBlank()
                        ) {
                            viewModel.addProduct(
                                ProductDto(
                                    id = 0L,
                                    productName = productName,
                                    productPrice = price.toDoubleOrNull() ?: 0.0,
                                    quantity = quantity.toIntOrNull() ?: 1,
                                    description = description,
                                    imageUrl = "https://via.placeholder.com/300",
                                    farmerName = ""
                                )
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = accentGreen
                    )
                ) {
                    Text(
                        text = "Add Product",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview() {
    AddProductScreen(navController = rememberNavController())
}
