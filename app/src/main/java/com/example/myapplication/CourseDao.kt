package com.example.myapplication

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface CourseDao {
    @Insert
    fun insertCourse(course : Course)

    @Update
    fun updateCourse(course: Course)

    @Delete
    fun deleteCourse(course: Course)

    @Query("SELECT * FROM course_table")
    fun getAllCourses(): List<Course> //hàm này trả về danh sách dữ liệu kiểu Course
}