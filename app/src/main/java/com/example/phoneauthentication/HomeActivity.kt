package com.example.phoneauthentication

import android.content.Intent
import android.content.QuickViewConstants
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.phoneauthentication.data.models.User
import com.example.phoneauthentication.viewModels.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth=FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            Log.d("TAG", "user phone no is ${auth.currentUser.phoneNumber.toString()}")
        }
        btnLogOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            addUserToDatabase()
        }
    }

    private fun addUserToDatabase() {
        var name = etEnterName.text.toString().trim()
        var email = etEnterEmail.text.toString().trim()

        if (!(name.isEmpty() || email.isEmpty())) {

        } else {
            Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }
}