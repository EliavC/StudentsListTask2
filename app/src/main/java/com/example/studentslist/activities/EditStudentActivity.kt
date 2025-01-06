package com.example.studentslist.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslist.MainActivity
import com.example.studentslist.R
import com.example.studentslist.models.StudentDataBase
import com.example.studentslist.models.Student




class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("studentId")
        val student = StudentDataBase.StudentDatabase.students.find { it.id == studentId }

        if (student != null) {
            val nameInput: EditText = findViewById(R.id.nameInput)
            val idInput: EditText = findViewById(R.id.idInput)
            val phoneInput: EditText = findViewById(R.id.phoneInput)
            val addressInput: EditText = findViewById(R.id.addressInput)
            val saveButton: Button = findViewById(R.id.saveButton)
            val deleteButton: Button = findViewById(R.id.deleteButton)
            val checkBox:CheckBox = findViewById<CheckBox>(R.id.checkBox)

            nameInput.setText(student.name)
            idInput.setText(student.id)
            phoneInput.setText(student.phone)
            addressInput.setText(student.address)
            checkBox.isChecked = student.isChecked


            saveButton.setOnClickListener {
                student.name = nameInput.text.toString()
                student.id = idInput.text.toString()
                student.phone = phoneInput.text.toString()
                student.address = addressInput.text.toString()
                student.isChecked = checkBox.isChecked
                finish()
                val intent = Intent(this, StudentDetailsActivity::class.java)
                intent.putExtra("studentId", student.id)
                startActivity(intent)
//
            }

            deleteButton.setOnClickListener {
                StudentDataBase.StudentDatabase.students.remove(student)
                finish()
                val intent = Intent(this, StudentsListActivity::class.java)
                intent.putExtra("studentId", student.id)
                startActivity(intent)
            }
        }
        val backToMainButton: Button = findViewById(R.id.btnBackToMain)
        backToMainButton.setOnClickListener {
            // Go back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Start MainActivity
            finish() // Close the current activity (StudentsListActivity)
        }
    }
}
