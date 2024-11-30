package com.example.mywishlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Surface

import androidx.compose.material3.MaterialTheme

import androidx.compose.ui.Modifier


import androidx.compose.ui.unit.dp
import com.example.mywishlistapp.ui.theme.MyWishListAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWishListAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(top = 56.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

