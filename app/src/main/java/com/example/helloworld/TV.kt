package com.example.helloworld

import java.io.Serializable

data class TV(val imgRes: String, val titleRes: String, val rating: Int, val price: String) :
    Serializable {

}
