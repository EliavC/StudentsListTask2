package com.example.studentslist.models

import com.example.studentslist.R

data class Student (
    var photoResID : Int = R.drawable.anonymoususer,
    var id: String,
    var name: String,
    var phone: String,
    var address: String,
    var isChecked: Boolean = false
)
