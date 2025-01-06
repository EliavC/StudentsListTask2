package com.example.studentslist.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslist.R
import com.example.studentslist.activities.StudentDetailsActivity
import com.example.studentslist.models.Student
class StudentAdapter(
    private val students: List<Student>,
    private val onStudentClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.studentName)
        private val idView: TextView = itemView.findViewById(R.id.studentId)
        private val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)


        fun bind(student: Student) {

            nameView.text = student.name
            idView.text = student.id
            checkBox.isChecked = student.isChecked

            checkBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }

            itemView.setOnClickListener {
                onStudentClick(student)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount() = students.size
}