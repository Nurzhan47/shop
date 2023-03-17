package com.example.helloworld

data class Category(val imgRes: Int, val titleRes: Int, val type: Int) {
    companion object {
        const val TV = 0
        const val WM = 1
        const val CS = 2
    }
}
