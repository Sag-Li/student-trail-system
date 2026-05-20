package model

data class Student(   val id: Int,
                      val name: String,
                      val email: String,
                      val status: StudentStatus
) {

    init {

        require(id > 0) {
            "Id inválido."
        }

        require(name.trim().length >= 3) {
            "Nome inválido."
        }

        require(email.contains("@") && email.contains(".")) {
            "Email inválido."
        }
    }
}