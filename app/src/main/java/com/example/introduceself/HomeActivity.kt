package com.example.introduceself


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idView = findViewById<TextView>(R.id.idView)
        if (intent.hasExtra("id")) {
            idView.text = "아이디 : " + intent.getStringExtra("id")
        }

        val close_btn = findViewById<Button>(R.id.close_btn)
        close_btn.setOnClickListener {
            finish()
        }

        val logo = findViewById<ImageView>(R.id.imageView3)

        val id = when ((1..6).random()) {
            1 -> R.drawable.i1
            2 -> R.drawable.i2
            3 -> R.drawable.i3
            4 -> R.drawable.i4
            5 -> R.drawable.i5
            else -> R.drawable.i3
        }

        logo.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))
    }
}



