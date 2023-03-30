package com.example.helloworld

import java.io.Serializable

data class Element(
    val imageUrl: String,
    val title: String,
    val rating: Int,
    val price: String,

) : Serializable
