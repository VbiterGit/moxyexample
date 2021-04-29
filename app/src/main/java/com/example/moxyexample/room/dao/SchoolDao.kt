package com.example.moxyexample.room.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Query
import com.example.moxyexample.room.entities.School

@Dao
interface SchoolDao: BaseDao<School> {
    @Query("SELECT * FROM school")
    fun getAllSchools(): List<School>

    @Query("""
            SELECT * FROM school 
            WHERE school_number > :number""")
    fun getAllSchoolsMoreNumber(number: Int): List<School>

    @Query("""
            SELECT * FROM school 
            WHERE school_number BETWEEN :minNumber AND :maxNumber""")
    fun getAllSchoolsBetweenNumbers(minNumber: Int, maxNumber: Int): List<School>

    @Query("""
            SELECT * FROM school 
            WHERE school_name LIKE :search""")
    fun findSchoolsWithName(search: String): List<School>

    @Query("SELECT * FROM school WHERE id IN (:schoolsId)")
    fun getSchoolsByIdList(schoolsId: List<Long>): List<School>

    @Query("""
        SELECT s.school_number, d.full_name 
        FROM school AS s
        JOIN director d ON s.id_director = d.id""")
    fun getSchoolsWithDirectors(): List<SchoolsWithDirectors>

    data class SchoolsWithDirectors(
        @ColumnInfo(name = "school_number")var schoolNumber: Int?,
        @ColumnInfo(name = "full_name")var fullName: String?
    )
}