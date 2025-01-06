package com.example.studentslist.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslist.MainActivity
import com.example.studentslist.R
import com.example.studentslist.models.Student
import com.example.studentslist.models.StudentDataBase
import android.widget.CheckBox


class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val nameInput: EditText = findViewById(R.id.nameInput)
        val idInput: EditText = findViewById(R.id.idInput)
        val phoneInput: EditText = findViewById(R.id.phoneInput)
        val addressInput: EditText = findViewById(R.id.addressInput)
        val saveButton: Button = findViewById(R.id.saveButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)
        val checkBox: CheckBox = findViewById<CheckBox>(R.id.checkBox)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val id = idInput.text.toString()
            val phone = phoneInput.text.toString()
            val address = addressInput.text.toString()




            if (name.isNotEmpty() && id.isNotEmpty()) {
                StudentDataBase.StudentDatabase.students.add(Student(photoResID=R.drawable.anonymoususer,id, name, phone, address,checkBox.isChecked))
                intent = Intent(this, this::class.java)
                finish()
                startActivity(intent) // Start the NewStudentActivity

                 // Return to the previous screen
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }

        }
        cancelButton.setOnClickListener {
            intent = Intent(this, this::class.java)
            finish()
            startActivity(intent)
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
