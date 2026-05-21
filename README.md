<h1 align="center"> Sistema de Alunos e Trilhas</h1>

<p align="center">
<strong>Sistema de gerenciamento de alunos, cursos e trilhas de aprendizado desenvolvido em Kotlin via console.</strong>
</p>

---

## Sobre o Projeto:

O projeto foi desenvolvido com o objetivo de aplicar conceitos de **Programação Orientada a Objetos (POO)**, encapsulamento, validações, organização em camadas e boas práticas de desenvolvimento de software utilizando Kotlin.

Toda a interação acontece via **console (terminal)**, com foco na lógica de negócio e estruturação do código.

---

##  Funcionalidades:

###  Gestão de Alunos:
- Cadastro de alunos
- Listagem de alunos
- Controle de status do aluno

###  Gestão de Cursos:
- Cadastro de cursos
- Listagem de cursos
- Controle de categoria e nível

###  Gestão de Trilhas:
- Cadastro de trilhas
- Listagem de trilhas
- Associação de cursos às trilhas
- Cálculo de carga horária total

###  Matrículas e Progresso:
- Matrícula de alunos em trilhas
- Registro de progresso
- Atualização de cursos concluídos
- Cálculo de percentual de progresso

###  Relatórios:
- Total de alunos cadastrados
- Total de cursos cadastrados
- Total de trilhas cadastradas
- Total de matrículas ativas

---

## Estrutura do Projeto:

| Camada   | Responsabilidade |
|----------|-----------------|
| 📦 model   | Entidades e enums do sistema |
| ⚙️ service | Regras de negócio e manipulação de dados |
| 🖥️ app     | Interface via console e fluxo do sistema |

---

## Conceitos Aplicados:

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Data Classes
- Enum Classes
- Separação em camadas (Model / Service / App)
- Validação de entradas do usuário
- Manipulação de listas
- Controle de fluxo no console

---

## Validações Implementadas:

- IDs únicos por entidade
- IDs maiores que zero
- Campos obrigatórios não vazios
- Validação de e-mail
- Controle de duplicidade
- Progresso entre 0% e 100%
- Status controlado via enums
  
---

## Checklist de Testes:

- [x] Cadastro de alunos funcionando
- [x] Cadastro de cursos funcionando
- [x] Cadastro de trilhas funcionando
- [x] Associação de cursos às trilhas
- [x] Matrícula de alunos em trilhas
- [x] Registro de progresso funcionando
- [x] Relatórios funcionando corretamente
- [x] Sistema resistente a entradas inválidas

---
