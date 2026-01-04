package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sid.agronear.R


data class WishlistItem(
    val id: Int,
    val name: String,
    val price: String,
    val seller: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(navController: NavController) {

    val wishlistItems = remember {
        listOf(
            WishlistItem(1, "Red Apples", "2.00 / kg", "Sunny Orchard", R.drawable.rowone),
            WishlistItem(2, "Fresh Tomatoes", "1.50 / kg", "Farmer John", R.drawable.rowtwo),
            WishlistItem(3, "Dairy Milk", "1.50 / L", "Hilltop Dairy", R.drawable.rowthree),
            WishlistItem(4, "Sweet Corn", "1.20 / kg", "Green Valley", R.drawable.rowfour)
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Wishlist",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF4E7C4A)
                )
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF2F2F2)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(wishlistItems) { item ->
                WishlistCard(item)
            }
        }
    }
}

@Composable
fun WishlistCard(item: WishlistItem) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "₹${item.price}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF2E7D32)
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.seller,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }

            IconButton(
                onClick = { /* remove from wishlist */ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.redheart),
                    contentDescription = "Remove",
                    tint = Color.Red,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}
