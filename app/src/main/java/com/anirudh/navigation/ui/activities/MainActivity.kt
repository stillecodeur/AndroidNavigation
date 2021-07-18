package com.anirudh.navigation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.anirudh.navigation.R
import com.anirudh.navigation.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //Use ViewBinding which is faster and easier than DataBinding
    private lateinit var uiBinding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uiBinding = ActivityMainBinding.inflate(
            LayoutInflater.from(this)
        )
        val view = uiBinding.root
        setContentView(view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        setUpAppBarConfiguration(navController)
        setUpNavigationView(navController)
        setUpBottomNavigationMenu(navController)


    }


    /**
     * To setup navigation controller with bottom view navigation
     */
    private fun setUpBottomNavigationMenu(navController: NavController) {
        uiBinding.containerView.bottomNavigationView.setupWithNavController(navController)
    }


    /**
     * To setup navigation controller with navigation view
     */
    private fun setUpNavigationView(navController: NavController){
        uiBinding.navigationView.setupWithNavController(navController)
    }

    /**
     * To setup app bar configuration
     */
    private fun setUpAppBarConfiguration(navController: NavController){
        appBarConfiguration= AppBarConfiguration(navController.graph,uiBinding.drawerLayout)
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    /**
     * To open navigation drawer from ham burger icon
     */
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_container).navigateUp(appBarConfiguration)
    }

}