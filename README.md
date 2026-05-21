<h1 align="center">Sistema de Alunos e Trilhas</h1>

<p align="center">
  <strong>Sistema de gerenciamento de alunos, cursos e trilhas de aprendizado desenvolvido em Kotlin via console.</strong>
</p>

---

## Sobre o Projeto:

O projeto foi desenvolvido com o objetivo de aplicar conceitos de **Programação Orientada a Objetos (POO)**, encapsulamento, validações, organização em camadas e boas práticas de desenvolvimento de software utilizando Kotlin.
Com toda a interação do sistema acontecendo diretamente no terminal (console), com foco na lógica de negócio, organização do código e experiência do usuário.

---

## Funcionalidades Implementadas:

### Gestão de Alunos:
- Cadastro de alunos
- Listagem de alunos
- Controle de status do aluno

### Gestão de Cursos:
- Cadastro de cursos
- Listagem de cursos
- Controle de categoria e nível

###  Gestão de Trilhas:
- Cadastro de trilhas
- Listagem de trilhas
- Associação de cursos às trilhas
- Controle de status das trilhas

### Matrículas e Progresso:
- Estrutura de matrícula
- Controle de progresso do aluno
- Atualização automática de status

###  Validações:
- Validação de IDs
- Validação de campos obrigatórios
- Validação de e-mail
- Controle de duplicidade de IDs

---

## Estrutura do Projeto:

O sistema foi organizado em camadas para garantir separação de responsabilidades e melhor manutenção do código.

| Camada | Responsabilidade |
| :--- | :--- |
| 📦 `src/model` | Entidades, enums e regras de negócio |
| ⚙️ `src/service` | Gerenciamento e manipulação dos dados |
| 🖥️ `src/app` | Execução do sistema e menu interativo |

---

## Conceitos Aplicados:

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Data Classes
- Enum Classes
- Validações utilizando `require`
- Listas mutáveis e imutáveis
- Organização em camadas
- Tratamento de entradas inválidas
- Controle de fluxo no console

---

## Validações Implementadas:

O sistema garante maior integridade dos dados através das seguintes validações:

- IDs maiores que zero
- Campos obrigatórios não vazios
- Validação básica de e-mail
- Controle de duplicidade de IDs
- Controle de progresso entre 0% e 100%
- Controle de status das entidades

---

2. Abra o projeto no IntelliJ IDEA.

3. Execute o arquivo `Main.kt`.

4. Utilize o menu interativo exibido no console.
