package com.example.shrinkio2.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shrinkio2.MainActivity
import com.example.shrinkio2.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class Register : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        Register.setOnClickListener(){
            registerUser()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


    private fun registerUser(){
        val email = email.text.toString()
        val password = password.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty() ){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                        auth.createUserWithEmailAndPassword(email, password).await()
                        withContext(Dispatchers.Main){
                            checkLoggInState()

                        }
                } catch (e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Register, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }

    override fun onStart() {
        super.onStart()
        checkLoggInState()
    }


    private fun checkLoggInState(){
        if(auth.currentUser == null ){

        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}