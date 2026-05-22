package app

import model.*
import service.CourseService
import service.StudentService
import service.TrailService

class App {

    private val studentService = StudentService()
    private val courseService = CourseService()
    private val trailService = TrailService()

    private val enrollments = mutableListOf<Enrollment>()

    fun start() {

        var option: Int?

        do {

            showMenu()

            option = readInt()

            when (option) {

                1 -> registerStudent()
                2 -> listStudents()
                3 -> registerCourse()
                4 -> listCourses()
                5 -> registerTrail()
                6 -> listTrails()
                7 -> addCourseToTrail()
                8 -> enrollStudent()
                9 -> menuProgress()
                10 -> showReports()

                11 -> println("Sistema encerrado.")

                else -> {
                    println("Opção inválida. Tente novamente.")
                    waitEnter()
                }
            }

        } while (option != 11)
    }

    private fun showMenu() {

        println()
        println("===== Sistema de Alunos e Trilhas =====")
        println("1. Cadastrar aluno")
        println("2. Listar alunos")
        println("3. Cadastrar curso")
        println("4. Listar cursos")
        println("5. Cadastrar trilha")
        println("6. Listar trilhas")
        println("7. Adicionar curso à trilha")
        println("8. Matricular aluno em trilha")
        println("9. Menu de Progresso")
        println("10. Exibir relatórios")
        println("11. Sair")
        println()

        print("Informe uma opção: ")
    }

    private fun readInt(): Int? {
        return readln().toIntOrNull()
    }

    private fun readRequiredInt(message: String): Int? {
        print(message)
        val value = readln().toIntOrNull()
        if (value == null) {
            println("Valor inválido.")
        }
        return value
    }

    private fun waitEnter() {
        println()
        print("Pressione ENTER para continuar...")
        readln()
    }

    private fun registerStudent() {

        println("\n===== Cadastro de Aluno =====")

        val id = readRequiredInt("ID do aluno: ") ?: return

        print("Nome: ")
        val name = readln()

        print("E-mail: ")
        val email = readln()

        try {

            val student = Student(id, name, email, StudentStatus.Ativo)

            val success = studentService.registerStudent(student)

            if (success) println("Aluno cadastrado com sucesso.")
            else println("Já existe um aluno com esse ID.")

        } catch (e: IllegalArgumentException) {
            println("Erro: ${e.message}")
        }

        waitEnter()
    }

    private fun listStudents() {

        println("\n===== Lista de Alunos =====")

        val students = studentService.listStudents()

        if (students.isEmpty()) {
            println("Nenhum aluno cadastrado.")
        } else {
            students.forEach {
                println(
                    """
ID: ${it.id}
Nome: ${it.name}
E-mail: ${it.email}
Status: ${it.status}
                    """.trimIndent()
                )
                println("-------------------")
            }
        }

        waitEnter()
    }

    private fun registerCourse() {

        println("\n===== Cadastro de Curso =====")

        val id = readRequiredInt("ID do curso: ") ?: return

        print("Título: ")
        val title = readln()

        print("Descrição: ")
        val description = readln()

        val workload = readRequiredInt("Carga horária: ") ?: return

        if (workload <= 0) {
            println("Carga horária inválida.")
            waitEnter()
            return
        }

        println("\nCategorias:")
        println("1. KOTLIN")
        println("2. ANDROID")
        println("3. ARQUITETURA")
        println("4. TESTES")
        println("5. DESIGN")
        print("Escolha: ")

        val category = when (readln().toIntOrNull()) {
            1 -> CourseCategory.Kotlin
            2 -> CourseCategory.Android
            3 -> CourseCategory.Arquitetura
            4 -> CourseCategory.Testes
            5 -> CourseCategory.Design
            else -> {
                println("Categoria inválida.")
                waitEnter()
                return
            }
        }

        println("\nNíveis:")
        println("1. Básico")
        println("2. Intermediário")
        println("3. Avançado")
        print("Escolha o nível: ")

        val level = when (readln().toIntOrNull()) {
            1 -> CourseLevel.Básico
            2 -> CourseLevel.Intermediário
            3 -> CourseLevel.Avançado
            else -> {
                println("Nível inválido.")
                waitEnter()
                return
            }
        }

        val course = Course(
            id,
            title,
            description,
            workload,
            level,
            category
        )

        val success = courseService.registerCourse(course)

        if (success) {
            println("Curso cadastrado com sucesso.")
        } else {
            println("Já existe um curso com esse ID.")
        }

        waitEnter()
    }

        private fun listCourses() {

        println("\n===== Lista de Cursos =====")

        val courses = courseService.listCourses()

        if (courses.isEmpty()) {
            println("Nenhum curso cadastrado.")
        } else {
            courses.forEach {
                println(
                    """
ID: ${it.id}
Título: ${it.title}
Descrição: ${it.description}
Carga Horária: ${it.workload}h
Categoria: ${it.category}
Nível: ${it.level}
                    """.trimIndent()
                )
                println("-------------------")
            }
        }

        waitEnter()
    }

    private fun registerTrail() {

        println("\n===== Cadastro de Trilha =====")

        val id = readRequiredInt("ID da trilha: ") ?: return

        print("Nome: ")
        val name = readln()

        print("Descrição: ")
        val description = readln()

        val trail = Trail(
            id,
            name,
            description,
            TrailStatus.Ativa
        )

        val success = trailService.registerTrail(trail)

        if (success) {
            println("Trilha cadastrada com sucesso.")
        } else {
            println("Já existe uma trilha com esse ID.")
        }

        waitEnter()
    }

    private fun listTrails() {

        println("\n===== Lista de Trilhas =====")

        val trails = trailService.listTrails()

        if (trails.isEmpty()) {
            println("Nenhuma trilha cadastrada.")
        } else {
            trails.forEach {
                println(
                    """
ID: ${it.id}
Nome: ${it.name}
Descrição: ${it.description}
Status: ${it.status}
Carga Horária Total: ${it.totalWorkload()}h
                    """.trimIndent()
                )
                println("-------------------")
            }
        }

        waitEnter()
    }

    private fun addCourseToTrail() {

        println("\n===== Adicionar Curso à Trilha =====")

        val trailId = readRequiredInt("ID da trilha: ") ?: return
        val courseId = readRequiredInt("ID do curso: ") ?: return

        val trail = trailService.findTrailById(trailId)
        val course = courseService.findCourseById(courseId)

        if (trail == null || course == null) {

            println("Trilha ou curso não encontrado.")

        } else {

            if (trail.addCourse(course)) {
                println("Curso adicionado à trilha.")
            } else {
                println("Não foi possível adicionar o curso.")
            }
        }

        waitEnter()
    }

    private fun enrollStudent() {

        println("\n===== Matrícula em Trilha =====")

        val studentId = readRequiredInt("ID do aluno: ") ?: return
        val trailId = readRequiredInt("ID da trilha: ") ?: return

        val student = studentService.findStudentById(studentId)
        val trail = trailService.findTrailById(trailId)

        if (student == null || trail == null) {

            println("Aluno ou trilha não encontrado.")

        } else {

            enrollments.add(
                Enrollment(
                    student,
                    trail,
                    0,
                    EnrollmentStatus.Ativa
                )
            )

            println("Aluno matriculado com sucesso.")
        }

        waitEnter()
    }

    private fun menuProgress() {

        var option: Int?

        do {

            println("\n===== Gerenciamento de Progresso =====")
            println("1. Ver progresso")
            println("2. Atualizar progresso")
            println("3. Voltar")
            print("Escolha: ")

            option = readln().toIntOrNull()

            when (option) {

                1 -> showProgress()
                2 -> registerProgress()
                3 -> println("Voltando...")

                else -> {
                    println("Opção inválida.")
                    waitEnter()
                }
            }

        } while (option != 3)
    }

    private fun showProgress() {

        println("\n===== Progresso dos Alunos =====")

        if (enrollments.isEmpty()) {
            println("Nenhuma matrícula cadastrada.")
        } else {
            enrollments.forEach {
                println(
                    """
Aluno: ${it.student.name}
Trilha: ${it.trail.name}
Concluídos: ${it.completedCourses}
Progresso: ${it.progress()}%
Status: ${it.status}
                    """.trimIndent()
                )
                println("-------------------")
            }
        }

        waitEnter()
    }

    private fun registerProgress() {

        println("\n===== Atualização de Progresso =====")

        val studentId = readRequiredInt("ID do aluno: ") ?: return

        val enrollment = enrollments.find { it.student.id == studentId }

        if (enrollment == null) {
            println("Matrícula não encontrada.")
        } else {

            val total = enrollment.trail.getCourses().size
            println("Total de cursos: $total")

            val completed = readRequiredInt("Cursos concluídos: ") ?: return

            enrollment.completedCourses = completed

            val completedCourses =
                readln().toIntOrNull()

            if (completedCourses == null) {
                println("Quantidade inválida.")
                waitEnter()
                return
            }

            val totalCourses =
                enrollment.trail.getCourses().size

            if (completedCourses < 0) {
                println("Quantidade inválida.")
                waitEnter()
                return
            }

            if (completedCourses > totalCourses) {
                println("A quantidade não pode ser maior que o total de cursos da trilha.")
                waitEnter()
                return
            }

            enrollment.completedCourses =
                completedCourses

            println()
            println("Progresso atualizado com sucesso.")

            println(
                "Progresso atual: ${
                    enrollment.progress()
                }%"
            )

            println("Progresso atualizado: ${enrollment.progress()}%")
        }

        waitEnter()
    }

    private fun showReports() {

        println("\n===== Relatórios =====")

        println("Total de alunos: ${studentService.listStudents().size}")
        println("Total de cursos: ${courseService.listCourses().size}")
        println("Total de trilhas: ${trailService.listTrails().size}")
        println("Total de matrículas: ${enrollments.size}")

        waitEnter()
    }
}
