package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentModel(
    @PrimaryKey(autoGenerate = true) var uId: Int = 0,
    @ColumnInfo(name = "hoTen") var hoTen: String?,
    @ColumnInfo(name = "maSv") var maSv: String?,
    @ColumnInfo(name = "diemTB") var diemTB: Float?
)