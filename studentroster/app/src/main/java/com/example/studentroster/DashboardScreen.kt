package com.example.studentroster

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class DashboardScreen(private val activity: Activity) {

    fun createView(): View {
        val mainLayout = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.WHITE)
        }

        val titleText = TextView(activity).apply {
            text = "Dashboard"
            textSize = 24f
            setTextColor(Color.parseColor("#333333"))
        }

        mainLayout.addView(titleText)

        return mainLayout
    }
}