package com.sid.agronear.Screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sid.agronear.R
import com.sid.agronear.viewmodel.ProductViewModel
import androidx.compose.runtime.collectAsState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: Long?
) {



    val viewModel: ProductViewModel = viewModel()
    val product by viewModel.selectedProduct.observeAsState()



    LaunchedEffect(productId) {
        productId?.let {
            viewModel.loadProduct(it)
        }
    }

    var productName by remember { mutableStateOf("Product Name") }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(product?.productName ?: "",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp)
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go back",
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = {

                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.redheart),
                        contentDescription = "Wishlist",
                        tint = Color.Unspecified
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF4E7C4A)
            ),
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rowtwo),
                contentDescription = productName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {


                Text(
                    text = product?.productPrice.toString(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                    color = Color(0xFF2E7D32)
                )

                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = "Available: ",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 8.dp),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = product?.quantity?.toString()?:"",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(modifier=Modifier.height(10.dp))

                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = "Sold by",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 8.dp),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = product?.farmerName?:"",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                    )
                }

                Spacer(modifier=Modifier.height(10.dp))
                androidx.compose.material3.Divider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color.LightGray
                )
                Spacer(modifier=Modifier.height(10.dp))

                Text(
                    text = product?.description?:"",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = 22.sp),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier=Modifier.height(10.dp))


                androidx.compose.material3.Divider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color.LightGray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview(){
   // ProductDetailScreen(navController = rememberNavController())
}