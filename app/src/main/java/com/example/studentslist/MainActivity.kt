package com.example.studentslist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import com.example.studentslist.activities.EditStudentActivity
import com.example.studentslist.activities.NewStudentActivity
import com.example.studentslist.activities.StudentDetailsActivity
import com.example.studentslist.activities.StudentsListActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set up padding to avoid system bars overlap
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find buttons by their IDs
        val navigateToStudentsListButton: Button = findViewById(R.id.btnNavigateToStudentsList)
        val navigateToNewStudentButton: Button = findViewById(R.id.btnNavigateToNewStudent)


        // Set click listener for the Students List button

            val intent = Intent(this, StudentsListActivity::class.java)
            startActivity(intent) // Start the Students List Activity



    }}