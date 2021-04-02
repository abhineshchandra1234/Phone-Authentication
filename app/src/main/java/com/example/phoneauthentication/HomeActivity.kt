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
import androidx.lifecycle.ViewModelProvider
import com.example.phoneauthentication.data.models.User
import com.example.phoneauthentication.databinding.ActivityHomeBinding
import com.example.phoneauthentication.viewModels.UserViewModel
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var userViewModel: UserViewModel
    private lateinit var userNumber: String
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        auth=FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            Log.d("TAG", "user phone no is ${auth.currentUser?.phoneNumber.toString()}")
            userNumber = auth.currentUser?.phoneNumber.toString()
        }
        binding.btnLogOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        binding.btnRegister.setOnClickListener {
            addUserToDatabase()
        }
    }

    private fun addUserToDatabase() {
        var name = binding.etEnterName.text.toString().trim()
        var email = binding.etEnterEmail.text.toString().trim()

        if (!(name.isEmpty() || email.isEmpty())) {
                val user = User(userNumber,name,email)
            userViewModel.addUser(user)
            Toast.makeText(applicationContext, "User added successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, UserDetails::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }
}