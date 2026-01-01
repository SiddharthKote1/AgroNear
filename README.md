AgroNear – Android Application

AgroNear is an Android application designed to connect farmers directly with buyers, enabling them to buy and sell agricultural products through a simple and secure mobile platform.

🚨 Problem Statement

Farmers often struggle to reach buyers directly and rely on intermediaries, leading to unfair pricing and limited market access. AgroNear provides a direct digital marketplace to bridge this gap.

✨ Key Features

Farmer and Buyer registration and login

Product upload with image and price by farmers

Browse and view agricultural products

Wishlist functionality for buyers

Secure access using JWT-based authentication

⚙️ How It Works

User registers or logs in as Farmer or Buyer

Farmers upload product details with images

Buyers browse products and add them to wishlist

App communicates securely with backend APIs using JWT

🛠️ Tech Stack

Kotlin

Jetpack Compose

MVVM Architecture

Retrofit & OkHttp

Kotlin Coroutines

SharedPreferences / DataStore

📦 Current Status

Android application is fully implemented and integrated with backend APIs.

flowchart TD
    A[App Launch] --> B[Login / Register]
    B --> C{User Role}
    C -->|Farmer| D[Farmer Dashboard]
    C -->|Buyer| E[Buyer Dashboard]

    D --> F[Upload Product]
    D --> G[View Uploaded Products]

    E --> H[Browse Products]
    H --> I[View Product Details]
    I --> J[Add to Wishlist]

