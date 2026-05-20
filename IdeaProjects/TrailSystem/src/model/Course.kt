package model

data class Course(
    val id: Int,
    val title: String,
    val workload: Int,
    val level: CourseLevel,
    val category: CourseCategory
) {

    init {

        require(id > 0) {
            "Id inválido."
        }

        require(title.isNotBlank()) {
            "Nome do curso inválido."
        }

        require(workload > 0) {
            "Carga horária inválida."
        }
    }
}

