package com.example.studentroster

import android.app.Activity
import android.graphics.Color
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class AddStudentScreen(private val activity: Activity) {

    fun createView(): View {
        // Create scroll view to handle overflow
        val scrollView = ScrollView(activity).apply {
            setBackgroundColor(Color.WHITE)
        }

        // Create main layout
        val mainLayout = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(80, 80, 80, 80)
        }

        // Create title
        val titleText = TextView(activity).apply {
            text = "Add Student"
            textSize = 28f
            setTextColor(Color.parseColor("#333333"))
            setPadding(0, 0, 0, 60)
            gravity = Gravity.CENTER
        }

        // Create Student ID field
        val studentIdEditText = EditText(activity).apply {
            hint = "Student ID"
            inputType = InputType.TYPE_CLASS_TEXT
            setPadding(40, 40, 40, 40)
            textSize = 16f
            setBackgroundResource(android.R.drawable.edit_text)
        }

        // Create Student Name field
        val studentNameEditText = EditText(activity).apply {
            hint = "Student Name"
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
            setPadding(40, 40, 40, 40)
            textSize = 16f
            setBackgroundResource(android.R.drawable.edit_text)
        }

        // Create Student Phone field
        val studentPhoneEditText = EditText(activity).apply {
            hint = "Student Phone"
            inputType = InputType.TYPE_CLASS_PHONE
            setPadding(40, 40, 40, 40)
            textSize = 16f
            setBackgroundResource(android.R.drawable.edit_text)
        }

        // Create Student Address field
        val studentAddressEditText = EditText(activity).apply {
            hint = "Student Address"
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            setPadding(40, 40, 40, 40)
            textSize = 16f
            setBackgroundResource(android.R.drawable.edit_text)
            minLines = 3
        }

        // Create Register button
        val registerButton = Button(activity).apply {
            text = "Register"
            textSize = 16f
            setPadding(0, 30, 0, 30)
            setOnClickListener {
                val studentId = studentIdEditText.text.toString()
                val studentName = studentNameEditText.text.toString()
                val studentPhone = studentPhoneEditText.text.toString()
                val studentAddress = studentAddressEditText.text.toString()

                // Check if all fields are filled
                if (studentId.isNotEmpty() && studentName.isNotEmpty() &&
                    studentPhone.isNotEmpty() && studentAddress.isNotEmpty()) {

                    // Create student object and add to roster
                    val student = Student(studentId, studentName, studentPhone, studentAddress)
                    StudentRoster.addStudent(student)

                    // Navigate back to dashboard
                    val dashboardScreen = DashboardScreen(activity)
                    activity.setContentView(dashboardScreen.createView())
                }
            }
        }

        // Set layout params for views
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(0, 0, 0, 30)
        }

        // Add views to layout
        mainLayout.addView(titleText)
        mainLayout.addView(studentIdEditText, layoutParams)
        mainLayout.addView(studentNameEditText, layoutParams)
        mainLayout.addView(studentPhoneEditText, layoutParams)
        mainLayout.addView(studentAddressEditText, layoutParams)
        mainLayout.addView(registerButton, layoutParams)

        scrollView.addView(mainLayout)
        return scrollView
    }
}