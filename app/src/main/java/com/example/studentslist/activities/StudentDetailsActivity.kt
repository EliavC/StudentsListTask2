package com.example.studentslist.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslist.MainActivity
import com.example.studentslist.R
import com.example.studentslist.models.StudentDataBase

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentId = intent.getStringExtra("studentId")
        val student = StudentDataBase.StudentDatabase.students.find { it.id == studentId }

        if (student != null) {
            val nameView: TextView = findViewById(R.id.nameView)
            val idView: TextView = findViewById(R.id.idView)
            val phoneView: TextView = findViewById(R.id.phoneView)
            val addressView: TextView = findViewById(R.id.addressView)
            val checkBox: CheckBox = findViewById<CheckBox>(R.id.checkBox)
            val editButton: Button = findViewById(R.id.editButton)

            nameView.text = student.name
            idView.text = student.id
            phoneView.text = student.phone
            addressView.text = student.address
            checkBox.isChecked = student.isChecked

            editButton.setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("studentId", student.id)
                startActivity(intent)
            }
           val  btnBackToMain = findViewById<Button>(R.id.btnBackToMain)
            btnBackToMain.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
