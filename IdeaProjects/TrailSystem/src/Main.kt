import service.CourseService
import service.StudentService
import service.TrailService

fun waitEnter() {

    println()
    print("Pressione ENTER para continuar...")

    readln()
}

fun main() {

    val studentService = StudentService()
    val courseService = CourseService()
    val trailService = TrailService()

    var option: Int?

    do {
        println()
        println("===== Sistema de Alunos e Trilhas =====")
        println("1. Cadastrar aluno")
        println("2. Listar alunos")
        println("3. Cadastrar curso")
        println("4. Listar cursos")
        println("5. Cadastrar trilha")
        println("6. Listar trilhas")
        println("7. Adicionar curso a uma trilha")
        println("8. Matricular aluno em trilha")
        println("9. Registrar progresso do aluno")
        println("10. Exibir relatórios")
        println("11. Sair")
        println()

        print("Informe uma opção: ")

        option = readln().toIntOrNull()

        when (option) {

            1 -> {
                println("Cadastro de aluno selecionado.")
                waitEnter()
            }
            2 -> {
                println("Listagem de alunos selecionada.")
                waitEnter()
            }
            3 -> {
                println("Cadastro de curso selecionado.")
                waitEnter()
            }
            4 -> {
                println("Listagem de cursos selecionada.")
                waitEnter()
            }
            5 -> {
                println("Cadastro de trilha selecionado.")
                waitEnter()
            }
            6 -> {
                println("Listagem de trilhas selecionada.")
                waitEnter()
            }
            7 -> {
                println("Adicionar curso à trilha selecionado.")
                waitEnter()
            }
            8 -> {
                println("Matrícula em trilha selecionada.")
                waitEnter()
            }
            9 -> {
                println("Registro de progresso selecionado.")
                waitEnter()
            }
            10 -> {
                println("Relatórios selecionados.")
                waitEnter()
            }
            11 -> {
                println("Sistema encerrado.")
                waitEnter()
            }
            else -> {
                println("Opção inválida. Tente novamente.")
                waitEnter()
            }
        }

    } while (option != 11)
}