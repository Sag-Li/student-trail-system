package model

class Trail (
    val id: Int,
    val name: String,
    val description: String,
    var status: TrailStatus
) {

    private val courses = mutableListOf<Course>()

    init {

        require(id > 0) {
            "Invalid id."
        }

        require(name.isNotBlank()) {
            "Invalid name."
        }
    }

    fun addCourse(course: Course): Boolean {

        if (
            status == TrailStatus.Concluida ||
            status == TrailStatus.Arquivada
        ) {
            return false
        }

        if (courses.any { it.id == course.id }) {
            return false
        }

        courses.add(course)

        return true
    }

    fun getCourses(): List<Course> {
        return courses.toList()
    }

    fun totalWorkload(): Int {
        return courses.sumOf { it.workload }
    }
}