package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R

// ----------------------------
// Dummy Wishlist Model
// ----------------------------
data class WishlistItem(
    val name: String,
    val price: String,
    val seller: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(navController: NavController) {

    // 🔹 Dummy data (REMOVE when backend is ready)
    val wishlistItems = listOf(
        WishlistItem(
            name = "Onion",
            price = "₹30 / kg",
            seller = "By Siddharth",
            image = R.drawable.rowthree
        ),
        WishlistItem(
            name = "Tomato",
            price = "₹25 / kg",
            seller = "By Anil Kumar",
            image = R.drawable.rowtwo
        )
    )

    Scaffold( // ✅ SINGLE SOURCE OF BACKGROUND
        topBar = {
            TopAppBar(
                title = { Text("Wishlist") }
            )
        }
    ) { paddingValues ->

        if (wishlistItems.isEmpty()) {
            EmptyWishlist()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(wishlistItems) { item ->
                    WishlistCard(item)
                }
            }
        }
    }
}

// ----------------------------
// Wishlist Item Card
// ----------------------------
@Composable
fun WishlistCard(item: WishlistItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8F4)),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFFB7D7C2), // soft green border
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = item.price,
                    color = Color(0xFF4CAF50)
                )
                Text(
                    text = item.seller,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            Button(
                onClick = { /* Buy action */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5C8D4E)
                )
            ) {
                Text("Buy")
            }
        }
    }
}

// ----------------------------
// Empty Wishlist UI
// ----------------------------
@Composable
fun EmptyWishlist() {
    Column(
        modifier = Modifier.fillMaxSize(), // ✅ NO background here
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.rowthree),
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your wishlist is empty ❤️")
        Text(
            "Save products to buy later",
            style = MaterialTheme.typography.bodySmall,
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

