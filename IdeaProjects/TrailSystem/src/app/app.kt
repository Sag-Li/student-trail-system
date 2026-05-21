package app

import model.*
import service.CourseService
import service.StudentService
import service.TrailService

class App {

    private val studentService = StudentService()

    private val courseService = CourseService()

    private val trailService = TrailService()

    private val enrollments =
        mutableListOf<Enrollment>()

    fun start() {

        var option: Int?

        do {

            showMenu()

            option = readln().toIntOrNull() ?: 0

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

                11 -> {
                    println("Sistema encerrado.")
                }

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
        println("9. Registrar progresso do aluno")
        println("10. Exibir relatórios")
        println("11. Sair")
        println()

        print("Informe uma opção: ")
    }

    private fun waitEnter() {

        println()

        print("Pressione ENTER para continuar...")

        readln()
    }

    private fun registerStudent() {

        println()
        println("===== Cadastro de Aluno =====")

        print("Informe o ID do aluno: ")
        val id = readln().toIntOrNull() ?: -1

        print("Informe o nome do aluno: ")
        val name = readln()

        print("Informe o e-mail do aluno: ")
        val email = readln()

        try {

            val student = Student(
                id,
                name,
                email,
                StudentStatus.Ativo
            )

            val success =
                studentService.registerStudent(student)

            if (success) {

                println("Aluno cadastrado com sucesso.")

            } else {

                println("Já existe um aluno com esse ID.")
            }

        } catch (e: IllegalArgumentException) {

            println("Erro: ${e.message}")
        }

        waitEnter()
    }

    private fun listStudents() {

        println()
        println("===== Lista de Alunos =====")

        val students =
            studentService.listStudents()

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

        println()
        println("===== Cadastro de Curso =====")

        print("Informe o ID do curso: ")
        val id = readln().toInt()

        print("Informe o título do curso: ")
        val title = readln()

        print("Informe a descrição: ")
        val description = readln()

        print("Informe a carga horária: ")
        val workload = readln().toInt()

        println()
        println("Categorias:")
        println("1. KOTLIN")
        println("2. ANDROID")
        println("3. ARQUITETURA")
        println("4. TESTES")
        println("5. DESIGN")
        print("Escolha a categoria: ")

        val category =
            when (readln().toInt()) {

                1 -> CourseCategory.Kotlin
                2 -> CourseCategory.Android
                3 -> CourseCategory.Arquitetura
                4 -> CourseCategory.Testes
                else -> CourseCategory.Design

            }

        println()
        println("Níveis:")
        println("1. Basico")
        println("2. Intermediário")
        println("3. Avançado")

        print("Escolha o nível: ")

        val level =
            when (readln().toInt()) {

                1 -> CourseLevel.Básico

                2 -> CourseLevel.Intermediário

                else -> CourseLevel.Avançado
            }

        val course = Course(
            id,
            title,
            workload,
            level,
            category
        )

        val success =
            courseService.registerCourse(course)

        if (success) {

            println("Curso cadastrado com sucesso.")

        } else {

            println("Já existe um curso com esse ID.")
        }

        waitEnter()
    }

    private fun listCourses() {

        println()
        println("===== Lista de Cursos =====")

        val courses =
            courseService.listCourses()

        if (courses.isEmpty()) {

            println("Nenhum curso cadastrado.")

        } else {

            courses.forEach {

                println(
                    """
ID: ${it.id}
Título: ${it.title}
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

        println()
        println("===== Cadastro de Trilha =====")

        print("Informe o ID da trilha: ")
        val id = readln().toInt()

        print("Informe o nome da trilha: ")
        val name = readln()

        print("Informe a descrição: ")
        val description = readln()

        val trail = Trail(
            id,
            name,
            description,
            TrailStatus.Ativa
        )

        val success =
            trailService.registerTrail(trail)

        if (success) {

            println("Trilha cadastrada com sucesso.")

        } else {

            println("Já existe uma trilha com esse ID.")
        }

        waitEnter()
    }

    private fun listTrails() {

        println()
        println("===== Lista de Trilhas =====")

        val trails =
            trailService.listTrails()

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

        println()
        println("===== Adicionar Curso à Trilha =====")

        print("Informe o ID da trilha: ")
        val trailId = readln().toInt()

        print("Informe o ID do curso: ")
        val courseId = readln().toInt()

        val trail =
            trailService.findTrailById(trailId)

        val course =
            courseService.findCourseById(courseId)

        if (trail == null || course == null) {

            println("Trilha ou curso não encontrado.")

        } else {

            val success =
                trail.addCourse(course)

            if (success) {

                println("Curso adicionado à trilha.")

            } else {

                println("Não foi possível adicionar o curso.")
            }
        }

        waitEnter()
    }

    private fun enrollStudent() {

        println()
        println("===== Matrícula em Trilha =====")

        print("Informe o ID do aluno: ")
        val studentId = readln().toIntOrNull()

        print("Informe o ID da trilha: ")
        val trailId = readln().toIntOrNull()

        val student =
            studentService.findStudentById(studentId)

        val trail =
            trailService.findTrailById(trailId)

        if (student == null || trail == null) {

            println("Aluno ou trilha não encontrado.")

        } else {

            val enrollment = Enrollment(
                student,
                trail,
                0,
                EnrollmentStatus.Ativa
            )

            enrollments.add(enrollment)

            println("Aluno matriculado com sucesso.")
        }

        waitEnter()
    }

    private fun menuProgress() {

        var option: Int?

        do {

            println()
            println("===== Gerenciamento de Progresso =====")
            println("1. Ver progresso dos alunos")
            println("2. Atualizar progresso")
            println("3. Voltar ao menu principal")
            println()

            print("Escolha uma opção: ")

            option =
                readln().toIntOrNull() ?: 0

            when (option) {

                1 -> showProgress()

                2 -> registerProgress()

                3 -> {
                    println("Voltando ao menu principal...")
                }

                else -> {
                    println("Opção inválida.")
                    waitEnter()
                }
            }

        } while (option != 3)
    }

    private fun showProgress() {

        println()
        println("===== Progresso dos Alunos =====")

        if (enrollments.isEmpty()) {

            println("Nenhuma matrícula cadastrada.")

        } else {

            enrollments.forEach {

                println(
                    """
Aluno: ${it.student.name}
Trilha: ${it.trail.name}
Cursos concluídos: ${it.completedCourses}
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

        println()
        println("===== Atualização de Progresso =====")

        print("Informe o ID do aluno: ")

        val studentId =
            readln().toIntOrNull() ?: 0

        val enrollment =
            enrollments.find {
                it.student.id == studentId
            }

        if (enrollment == null) {

            println("Matrícula não encontrada.")

        } else {

            println()

            println(
                "Total de cursos da trilha: ${
                    enrollment
                        .trail
                        .getCourses()
                        .size
                }"
            )

            print(
                "Informe quantos cursos o aluno concluiu: "
            )

            val completedCourses =
                readln().toIntOrNull() ?: 0

            enrollment.completedCourses =
                completedCourses

            println()
            println("Progresso atualizado com sucesso.")

            println(
                "Progresso atual: ${
                    enrollment.progress()
                }%"
            )
        }

        waitEnter()
    }

    private fun showReports() {

        println()
        println("===== Relatórios =====")

        println(
            "Total de alunos: ${
                studentService
                    .listStudents()
                    .size
            }"
        )

        println(
            "Total de cursos: ${
                courseService
                    .listCourses()
                    .size
            }"
        )

        println(
            "Total de trilhas: ${
                trailService
                    .listTrails()
                    .size
            }"
        )

        println(
            "Total de matrículas: ${
                enrollments.size
            }"
        )

        waitEnter()
    }
}
