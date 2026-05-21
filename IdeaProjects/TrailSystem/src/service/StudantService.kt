package service

import model.Student

class StudentService {

    private val students = mutableListOf<Student>()

    fun registerStudent(student: Student): Boolean {

        if (students.any { it.id == student.id }) {
            return false
        }

        students.add(student)
        return true
    }

    fun listStudents(): List<Student> {
        return students.toList()
    }

    fun findStudentById(id: Int): Student? {
        return students.find { it.id == id }
    }
}