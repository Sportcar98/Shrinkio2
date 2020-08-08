package com.example.shrinkio2.Fragments

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shrinkio2.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_post.*


class PostFragment : AppCompatActivity() {

    lateinit var feels: EditText
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_post)


        feels = findViewById(R.id.feels)

        post.setOnClickListener{
            var name = feels.text.toString()
            var firebaseDatabase = FirebaseDatabase.getInstance()
            var databaseReference = firebaseDatabase.getReference()
            databaseReference.child("Users").child("Posts").push().setValue(name)
            Toast.makeText(applicationContext, "Sent", Toast.LENGTH_SHORT).show()
            finish()
        }

    }



    }


