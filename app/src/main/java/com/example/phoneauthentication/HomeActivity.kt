package com.example.phoneauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth=FirebaseAuth.getInstance()
        btnLogOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}