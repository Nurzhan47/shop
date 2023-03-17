package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val categoryAdapter = CategoryAdapter(this::categoryOnClick)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val categories = listOf(
            Category(R.drawable.tv, R.string.tv, Category.TV),
            Category(R.drawable.baseline_local_laundry_service_24, R.string.wm, Category.WM),
            Category(R.drawable.closet, R.string.app_name, Category.CS),
            Category(R.drawable.tv, R.string.app_name, Category.TV),
            Category(R.drawable.tv, R.string.app_name, Category.TV),
        )

        findViewById<RecyclerView>(R.id.recycler).apply {
            adapter = categoryAdapter
            categoryAdapter.updateList(categories)
        }
    }

    private fun categoryOnClick(category: Category, position: Int) {
        println("Current category: $category")
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra(KEY_CATEGORY_TYPE, category.type)
        startActivity(intent)
    }

    companion object {
        const val KEY_CATEGORY_TYPE = "categoryType"
    }
}
