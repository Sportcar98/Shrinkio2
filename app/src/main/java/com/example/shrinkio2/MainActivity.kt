package com.example.shrinkio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shrinkio2.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val notificationsFragment =
            NotificationsFragment()
        val profileFragment = ProfileFragment()
        val messagesFragment = MessagesFragment()
        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miNotifications -> setCurrentFragment(notificationsFragment)
                R.id.miProfile -> setCurrentFragment(profileFragment)
                R.id.miMessages -> setCurrentFragment(messagesFragment)
            }
            true
        }


        add_post.setOnClickListener{view ->
            val intent = Intent(this, PostFragment::class.java)
            startActivity(intent)
        }



    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()

        }

    override fun onBackPressed() {

    }
}