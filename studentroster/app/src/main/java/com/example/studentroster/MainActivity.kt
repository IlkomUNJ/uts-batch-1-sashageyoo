package com.example.studentroster

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dashboardScreen = DashboardScreen(this)
        setContentView(dashboardScreen.createView())
//        val loginScreen = LoginScreen(this)
//        setContentView(loginScreen.createView())
    }
}