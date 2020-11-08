package com.example.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.db.Interactors
import com.example.myapplication.demoui.MainActivity
import com.example.myapplication.ui.BaseActivity
import com.example.myapplication.ui.ViewModelFactory
import com.example.myapplication.utils.Constants


class SplashActivity : BaseActivity() {

    private lateinit var splashViewModel: SplashViewModel

    override val layoutId: Int
        get() = R.layout.splash_layout

    override fun initializeViewModel() {
        splashViewModel = SplashViewModel(application, Interactors());
        /*splashViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory
        ).get(SplashViewModel::class.java)*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainScreen()
    }

    override fun observeViewModel() {
    }

    private fun navigateToMainScreen() {
        Handler().postDelayed({
            var intent: Intent = Intent();
            intent.setClass(this,MainActivity::class.java)
           startActivity(intent);
            finish()
        }, Constants.SPLASH_DELAY.toLong())
    }
}