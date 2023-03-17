package com.example.helloworld

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.io.Serializable


@Suppress("DEPRECATION")
inline fun <reified T : java.io.Serializable> Bundle.serializable(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getSerializable(key) as? T
}

inline fun <reified T : Serializable> Intent.serializable(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(
        key,
        T::class.java
    )
    else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
}

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val p = intent.serializable<TV>("profile")
        println(p)
        findViewById<ImageView>(R.id.flag).apply {
            Picasso.with(this@MainActivity3).load(p?.imgRes).into(this)
        }
        findViewById<TextView>(R.id.name).apply {
//            if (p != null) {
//                setText(p.titleRes)
//            }
            p?.titleRes?.let(this::setText)
        }
        findViewById<TextView>(R.id.subtitle).apply {
            p?.rating?.toString()?.let(this::setText)
        }
        findViewById<TextView>(R.id.price).apply {
            p?.price?.let(this::setText)
        }

    }
}