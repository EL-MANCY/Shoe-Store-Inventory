package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        Timber.plant(Timber.DebugTree())


        val navController=this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController,appBarConfiguration)




    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.myNavHostFragment)
        return  navController.navigateUp()}

}
