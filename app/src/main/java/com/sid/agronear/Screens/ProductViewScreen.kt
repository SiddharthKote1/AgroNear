package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R
import android.content.Intent
import android.net.Uri
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.sid.agronear.Screens.viewmodel.AddProductViewModel
import com.sid.agronear.Screens.viewmodel.ProductDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductViewScreen(
    navController: NavController,
    productId: Long
) {

    val viewModel: ProductDetailViewModel = viewModel()
    val context = LocalContext.current

    var quantity by remember { mutableStateOf(1) }

    val screenColor = Color(0xFFE8F5E9)
    val cardColor = Color(0xFFF1F8F4)
    val accentGreen = Color(0xFF5C8D4E)

    LaunchedEffect(productId) {
        viewModel.loadProduct(productId)
    }

    Scaffold(
        containerColor = screenColor,
        topBar = {
            TopAppBar(
                title = { Text("Product Details") },
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

        if (viewModel.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }

        val product = viewModel.product ?: return@Scaffold

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

                // ---------- IMAGE ----------
                AsyncImage(
                    model = product.imageProduct,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // ---------- NAME ----------
                Text(
                    text = product.productName,
                    style = MaterialTheme.typography.titleLarge
                )

                // ---------- PRICE ----------
                Text(
                    text = "₹${product.productPrice} / kg",
                    color = accentGreen,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "By ${product.userName}",
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                // ---------- QUANTITY ----------
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(12.dp))
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { if (quantity > 1) quantity-- }) {
                        Icon(Icons.Default.Delete, contentDescription = "Minus")
                    }

                    Text("$quantity kg")

                    IconButton(onClick = { quantity++ }) {
                        Icon(Icons.Default.Add, contentDescription = "Plus")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // ---------- TOTAL ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Total Price")
                    Text(
                        text = "₹${quantity * product.productPrice}",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // ---------- WHATSAPP ----------
                Button(
                    onClick = {
                        val message =
                            "Hi, I'm interested in ${product.productName} ($quantity kg)"
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://wa.me/?text=${Uri.encode(message)}")
                        )
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = accentGreen)
                ) {
                    Text("Buy via WhatsApp", color = Color.White)
                }

                Spacer(modifier = Modifier.height(12.dp))

                // ---------- WISHLIST ----------
                OutlinedButton(
                    onClick = {
                        // TODO: call wishlist API
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.Red)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Add to Wishlist")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductViewScreenPreview() {
   // ProductViewScreen(navController = rememberNavController(context=LocalContext.current))
}
