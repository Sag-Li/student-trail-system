package service

import model.Course

class CourseService {

    private val courses = mutableListOf<Course>()

    fun registerCourse(course: Course): Boolean {

        if (courses.any { it.id == course.id }) {
            return false
        }

        courses.add(course)

        return true
    }

    fun listCourses(): List<Course> {
        return courses.toList()
    }

    fun findCourseById(id: Int): Course? {
        return courses.find { it.id == id }
    }
}