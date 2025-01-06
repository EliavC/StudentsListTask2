package com.example.studentslist.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslist.R
import com.example.studentslist.adapters.StudentAdapter
import com.example.studentslist.models.StudentDataBase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = StudentAdapter(StudentDataBase.StudentDatabase.students) { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("studentId", student.id)
            startActivity(intent)

        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }

    }
}