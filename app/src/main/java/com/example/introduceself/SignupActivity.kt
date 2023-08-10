package com.example.introduceself


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val name_et = findViewById<EditText>(R.id.upName)
        val id_et = findViewById<EditText>(R.id.upId)
        val pw_et = findViewById<EditText>(R.id.upPw)

        val btn = findViewById<Button>(R.id.SignInBtn)

        btn.setOnClickListener {
            if(name_et.text.toString().trim().isEmpty()||id_et.text.toString().trim().isEmpty()||pw_et.text.toString().trim().isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        finish()

        val intent = Intent(this,SignInActivity::class.java).apply {
            putExtra("id", id_et.text.toString())
            putExtra("pw", pw_et.text.toString())
        }

        setResult(RESULT_OK, intent)

        if ( isFinishing) finish()
    }
}