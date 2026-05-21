package model

data class Enrollment(
    val student: Student,
    val trail: Trail,
    var completedCourses: Int = 0,
    var status: EnrollmentStatus = EnrollmentStatus.Ativa
) {

    fun progress(): Int {

        val totalCourses = trail.getCourses().size

        if (totalCourses == 0) {
            return 0
        }

        return (completedCourses * 100) / totalCourses
    }
}
