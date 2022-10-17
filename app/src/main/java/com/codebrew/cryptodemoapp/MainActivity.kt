package com.codebrew.cryptodemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.codebrew.cryptodemoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initNavController()

    }

    fun setupNavHost() {
        val navHostFragment = binding.navHostFragment as NavHostFragment
        val navController = navHostFragment.navController
    }

    private fun initNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

   /* fun navigate(){
        val action =
                .actionSpecifyAmountFragmentToConfirmationFragment()
        view.findNavController().navigate(action)
    }*/


}

