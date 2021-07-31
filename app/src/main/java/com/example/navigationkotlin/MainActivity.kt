package com.example.navigationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar        : Toolbar
    private lateinit var navController  : NavController
    private lateinit var bottomNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar         = findViewById(R.id.activity_main_toolbar)
        bottomNavigation  = findViewById(R.id.navigationView)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController

        //to remove UpButton fromToolbar
        val destinations = setOf(R.id.countryFragment, R.id.favoritesFragment)
        // Define AppBarConfiguration: Connect DrawerLayout with Navigation Component
        val appBarConfiguration = AppBarConfiguration(destinations)

        // Connect Toolbar with NavController
        toolbar.setupWithNavController(navController, appBarConfiguration)

        // Connect NavigationView with NavController
        bottomNavigation.setupWithNavController(navController)
    }


}