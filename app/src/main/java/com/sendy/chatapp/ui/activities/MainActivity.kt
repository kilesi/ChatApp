package com.sendy.chatapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.sendy.chatapp.R
import com.sendy.chatapp.ui.fragments.ChatFragment
import com.sendy.chatapp.ui.fragments.HomeFragment
import com.sendy.chatapp.ui.fragments.LikesFragment
import com.sendy.chatapp.ui.fragments.ProfileViewersFragment
import com.sendy.chatapp.ui.fragments.SendFragment
import com.sendy.chatapp.ui.fragments.ShareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toogle = ActionBarDrawerToggle(this, drawer_layout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        navView.setNavigationItemSelectedListener(this)

        displaySelectedScreen(-1)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displaySelectedScreen(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }

    fun displaySelectedScreen(id: Int){
        val fragment = when(id){
            R.id.nav_home -> {
                HomeFragment()
            }
            R.id.nav_chat -> {
                ChatFragment()
            }
            R.id.nav_profile -> {
                ProfileViewersFragment()
            }
            R.id.nav_likes_you -> {
                LikesFragment()
            }
            R.id.nav_share -> {
                ShareFragment()
            }
            R.id.nav_send -> {
                SendFragment()
            }
            else -> {
                HomeFragment()
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}
