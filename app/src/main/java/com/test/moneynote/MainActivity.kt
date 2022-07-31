package com.test.moneynote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.moneynote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.includeNavBar)

//        val navView: BottomNavigationView = binding.includeNavBar.navbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNav = binding.includeNavBar.bottomnav
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.item1 -> {
                    true
                }
                R.id.item2 -> {
                    true
                }
                else -> false
            }
//            return@setOnItemSelectedListener true
        }
//        BottomNavigationView.OnNavigationItemSelectedListener{}

//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//
//            )
//        )

        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)


    }

}