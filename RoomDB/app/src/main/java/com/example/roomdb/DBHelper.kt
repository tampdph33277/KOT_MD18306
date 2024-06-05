package com.example.roomdb


import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Database(entities = [StudentModel::class], version = 1)
abstract class StudentDB : RoomDatabase() {
    abstract fun studentDAO(): StudentDAO
}

@Dao
interface StudentDAO {
    @Query("SELECT * FROM StudentModel")
    fun getAll(): List<StudentModel>


    @Query("SELECT * FROM StudentModel WHERE uId IN (:userId)")
    fun loadAllId(userId: IntArray): List<StudentModel>

    @Insert
    fun insert(vararg users: StudentModel)

    @Delete
    fun delete(user: StudentModel)

    @Query("SELECT * FROM StudentModel WHERE uId = :uId")
    fun getId(uId: Int): StudentModel

    @Update
    fun update(users: StudentModel)

}