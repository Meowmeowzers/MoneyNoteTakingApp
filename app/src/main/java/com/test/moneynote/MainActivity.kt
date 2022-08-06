package com.test.moneynote

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.moneynote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.includeAppbar.toolbar)

//        val navView: BottomNavigationView = binding.includeNavBar.navbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNav = binding.includeNavBar.bottomnav

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.secondFragment,
                R.id.thirdFragment2,
                R.id.otherFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.mainFragment -> {
                    navController.navigate(R.id.mainFragment)
                    true
                }
                R.id.note -> {
                    navController.navigate(R.id.secondFragment)
                    true
                }
                R.id.note2 -> {
                    navController.navigate(R.id.thirdFragment2)
                    true
                }
                R.id.other -> {
                    navController.navigate(R.id.otherFragment)
                    true
                }
                else -> false
            }
//            return@setOnItemSelectedListener true
        }

        bottomNav.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.mainFragment -> {
                    Toast.makeText(applicationContext, "Clicked1", Toast.LENGTH_SHORT).show()
                }
                R.id.note -> {
                    Toast.makeText(applicationContext, "Clicked2", Toast.LENGTH_SHORT).show()
                }
                R.id.note2 -> {
                    Toast.makeText(applicationContext, "Clicked3", Toast.LENGTH_SHORT).show()
                }
                R.id.other -> {
                    Toast.makeText(applicationContext, "Clicked4", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}