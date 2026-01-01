@file:JvmName("MainScreenKt")

package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.sid.agronear.R
import androidx.navigation.compose.rememberNavController


data class DummyProduct(
    val name: String,
    val price: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {

    var searchText by remember { mutableStateOf("") }

    // 🔹 Dummy banners
    val bannerImages = listOf(
        R.drawable.rowone,
        R.drawable.rowtwo,
        R.drawable.rowthree,
        R.drawable.rowfour
    )

    // 🔹 Dummy products (REMOVE when backend is ready)
    val products = listOf(
        DummyProduct("Tomato", "₹25 / kg", R.drawable.rowone),
        DummyProduct("Potato", "₹20 / kg", R.drawable.rowtwo),
        DummyProduct("Onion", "₹30 / kg", R.drawable.rowthree),
        DummyProduct("Brinjal", "₹35 / kg", R.drawable.rowfour),
        DummyProduct("Cabbage", "₹28 / kg", R.drawable.rowone),
        DummyProduct("Carrot", "₹40 / kg", R.drawable.rowtwo)
    )

    Scaffold(
        containerColor = Color(0xFFF5EFEA),
        topBar = {
            TopAppBar(
                title = { Text("AgroNear") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Search products") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.searchicon),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )

            // 🖼️ Banner Scroll
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(bannerImages) { image ->
                    Image(
                        painter = painterResource(image),
                        contentDescription = null,
                        modifier = Modifier
                            .width(280.dp)
                            .height(150.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🧺 Product Grid (2 per row)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(products) { product ->
                    DummyProductCard(product)
                }
            }
        }
    }
}


@Composable
fun DummyProductCard(product: DummyProduct) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(product.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = product.price,
                color = Color(0xFF4CAF50),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}
