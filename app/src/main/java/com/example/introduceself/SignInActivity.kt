package com.example.introduceself

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val id_et:EditText = findViewById(R.id.Address)
        val pw_et:EditText = findViewById(R.id.Password)
        val loginBtn: Button = findViewById(R.id.loginbtn)
        val signUpBtn: Button = findViewById(R.id.registerbtn)

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("id") ?: ""
                    val user_pw = it.data?.getStringExtra("pw") ?: ""
                    id_et.setText(user_id)
                    pw_et.setText(user_pw)
                }
            }

        loginBtn.setOnClickListener {
            if (id_et.text.toString().trim().isEmpty() || pw_et.text.toString().trim().isEmpty()) {
                Toast.makeText(this,getString(R.string.loginErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("id", id_et.text.toString())
            startActivity(intent)
        }


        signUpBtn.setOnClickListener{
            val intent = Intent(this,SignupActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}
