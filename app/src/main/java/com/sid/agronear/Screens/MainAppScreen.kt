package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sid.agronear.R
import com.sid.agronear.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(navController: NavController) {
    var searchproduct by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "AgroNear",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 26.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF4E7C4A)
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.searchicon),
                            contentDescription = "SearchIcon",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.iconsbell),
                            contentDescription = "Notifications",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Routes.AddProductScreen) },
                containerColor = Color(0xFF4E7C4A),
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 10.dp, bottom = 10.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Add"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
        //  containerColor = Color(0xFF4E7C4A)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFE8F5E9))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    value = searchproduct,
                    onValueChange = { searchproduct = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .padding(16.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    ),
                    singleLine = true,
                    placeholder = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.searchicon),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = Color.DarkGray
                            )

                            Spacer(modifier = Modifier.width(8.dp)) // ✅ spacing

                            Text(
                                text = "Search product",
                                fontSize = 14.sp,
                                color = Color.DarkGray
                            )
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.LightGray,
                        unfocusedContainerColor = Color.LightGray,
                        focusedBorderColor = Color(0xFF4E7C4A),
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color(0xFF4E7C4A),
                        cursorColor = Color(0xFF4E7C4A)
                    ),
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.microphone),
                                contentDescription = "voice search",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    })
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(productList) { product ->
                        ProductCard(
                            modifier = Modifier,
                            productName = product.name,
                            price = product.price,
                            farmerName = product.farmer,
                            imageRes = product.image,
                            onClick = {navController.navigate(Routes.ProductDetailScreen)}
                        )
                    }
                }
            }
        }
    }
}

data class Product(
    val name: String,
    val price: String,
    val farmer: String,
    val image: Int
)

val productList = listOf(
    Product(
        name = "Fresh Tomatoes",
        price = "40 / kg",
        farmer = "Ramesh Farmer",
        image = R.drawable.rowone
    ),
    Product(
        name = "Organic Potatoes",
        price = "30 / kg",
        farmer = "Suresh Farmer",
        image = R.drawable.rowtwo
    ),
    Product(
        name = "Green Chillies",
        price = "80 / kg",
        farmer = "Anil Farmer",
        image = R.drawable.rowthree
    ),
    Product(
        name = "Onions",
        price = "35 / kg",
        farmer = "Mahesh Farmer",
        image = R.drawable.rowfour
    ),
    Product(
        name = "Carrots",
        price = "50 / kg",
        farmer = "Raj Farmer",
        image = R.drawable.rowfour
    )
)


@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    productName: String,
    price: String,
    farmerName: String,
    imageRes: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column {

            // 🔹 Product Image
            Image(
                painter = painterResource(imageRes),
                contentDescription = productName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {

                Text(
                    text = productName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "By $farmerName",
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "₹ $price",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4E7C4A)
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainAppScreenPreview(){
    MainAppScreen(navController= rememberNavController())
}