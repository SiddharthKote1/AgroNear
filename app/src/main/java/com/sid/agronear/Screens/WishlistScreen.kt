package com.sid.agronear.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.sid.agronear.Screens.viewmodel.WishlistViewModel
import com.sid.agronear.DataClasses.WishlistResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(navController: NavController) {

    val viewModel: WishlistViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.loadWishlist()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Wishlist") })
        }
    ) { paddingValues ->

        when {
            viewModel.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            viewModel.wishlist.isEmpty() -> {
                EmptyWishlist()
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(viewModel.wishlist) { item ->
                        WishlistCard(
                            item = item,
                            onRemove = {
                                viewModel.removeFromWishlist(item.productId)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WishlistCard(
    item: WishlistResponse,
    onRemove: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8F4)),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                Color(0xFFB7D7C2),
                RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = item.productImage,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(item.productName)
                Text(
                    "₹${item.productPrice} / kg",
                    color = Color(0xFF4CAF50)
                )
                Text(
                    "By ${item.userName}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            OutlinedButton(onClick = onRemove) {
                Text("Remove")
            }
        }
    }
}

@Composable
fun EmptyWishlist() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Your wishlist is empty ❤️")
        Text(
            "Save products to buy later",
            color = Color.Gray
        )
    }
}

// ----------------------------
// Preview (WORKS)
// ----------------------------
@Preview(showBackground = true)
@Composable
fun WishlistScreenPreview() {
    WishlistScreen(navController = rememberNavController())
}

