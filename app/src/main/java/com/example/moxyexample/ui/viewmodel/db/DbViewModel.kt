package com.example.moxyexample.ui.viewmodel.db

import androidx.lifecycle.ViewModel
import com.example.moxyexample.room.entities.Classes
import com.example.moxyexample.room.entities.ClassesToSchool
import com.example.moxyexample.room.entities.Director
import com.example.moxyexample.room.entities.School

class DbViewModel: ViewModel() {
    private val directors: List<Director> by lazy {
        listOf(
            Director(1, "Имя_1", "Фамилия_1", "Отчество_1", "ФИО_1"),
            Director(2, "Имя_2", "Фамилия_2", "Отчество_2", "ФИО_2"),
            Director(3, "Имя_3", "Фамилия_3", "Отчество_3", "ФИО_3"),
            Director(4, "Имя_4", "Фамилия_4", "Отчество_4", "ФИО_4"),
            Director(5, "Имя_5", "Фамилия_5", "Отчество_5", "ФИО_5"),
            Director(6, "Имя_6", "Фамилия_6", "Отчество_6", "ФИО_6"),
            Director(7, "Имя_7", "Фамилия_7", "Отчество_7", "ФИО_7"),
            Director(8, "Имя_8", "Фамилия_8", "Отчество_8", "ФИО_8"),
        )
    }
    private val schools: List<School> by lazy {
        listOf(
            School(1, 4, "ООШ Веселая", 1),
            School(2, 7, "ООШ Грустная", 3),
            School(3, 12, "ООШ Радостная", 5),
            School(4, 31, "ООШ Широкая", 8),
        )
    }
    private val classes: List<Classes> by lazy {
        listOf(
            Classes(1, 4, "А"),
            Classes(2, 7, "Б"),
            Classes(3, 1, "В"),
            Classes(4, 2, "Д"),
        )
    }

    private val classesToSchool: List<ClassesToSchool> by lazy{
        listOf(
            ClassesToSchool(1, 1, 2),
            ClassesToSchool(2, 4, 3)
        )
    }

    fun loadDataToDb() {

    }
}