<h1 align="center"> Sistema de Gerenciamento Escolar</h1>

<p align="center">
  <strong>Sistema de gerenciamento de alunos, cursos e trilhas de aprendizado desenvolvido em Kotlin via console.</strong>
</p>

---

##  Sobre o Projeto:

O projeto foi criado com o objetivo de aplicar conceitos sólidos de **Programação Orientada a Objetos (POO)**, encapsulamento, validações rigorosas e organização arquitetural em camadas, seguindo as melhores práticas de desenvolvimento de software.

> 💡 **Nota:** Toda a interface do sistema funciona diretamente no terminal (console), focando na lógica de negócio e robustez do código.

---

##  Funcionalidades Principais

* 🧑‍🎓 **Gestão de Alunos:** Cadastro completo e controle de matrículas.
* 📖 **Gestão Acadêmica:** Cadastro de cursos e criação de trilhas de aprendizado.
* 📈 **Controle de Progresso:** Monitoramento da evolução do aluno nas trilhas e controle de status.
* 📊 **Relatórios:** Listagem de dados e geração de relatórios simples do sistema.
* 🔒 **Segurança:** Validações de dados em tempo de inserção para consistência do banco em memória.

---

##  Estrutura do Projeto (camadas):

A arquitetura do sistema foi dividida de forma clara para garantir a separação de responsabilidades:


| Camada | Descrição |
| :--- | :--- |
| 🖥️ **`src/app`** | Ponto de entrada do sistema. Responsável pelo menu interativo e execução. |
| 📦 **`src/model`** | Contém as entidades, objetos de valor, enums e regras de negócio essenciais. |
| ⚙️ **`src/service`** | Camada de serviços. Responsável pelas regras de gerenciamento e manipulação dos dados. |

---

##  Conceitos Avançados Aplicados

- [x] **Programação Orientada a Objetos (POO)**.
- [x] **Encapsulamento** para proteção de propriedades sensíveis.
- [x] **Data Classes** para representação limpa de dados.
- [x] **Enum Classes** para padronização de estados e status.
- [x] **Validações nativas** utilizando a estrutura `require` do Kotlin.
- [x] Manipulação segura de **Listas mutáveis e imutáveis**.

---

## Validações Implementadas:

> O sistema garante a integridade dos dados impedindo estados inválidos através de:

* **Validação de IDs:** Bloqueio de identificadores menores ou iguais a zero.
- **Campos Obrigatórios:** Restrição de nomes ou textos vazios.
* **Formatação de Email:** Checagem de padrão de e-mail válido.
- **Unicidade:** Mecanismo que evita a duplicidade de IDs no sistema.

---

## Como Executar o Projeto:

Para rodar o projeto localmente em sua máquina, siga os passos abaixo:

1. Clone este repositório para o seu ambiente local.
2. Abra a pasta do projeto utilizando a IDE **IntelliJ IDEA**.
3. Aguarde a sincronização das dependências do Kotlin (se houver).
4. Navegue até a pasta `src/app` e localize o arquivo **`Main.kt`**.
5. Clique com o botão direito no arquivo e selecione **Run 'Main.kt'**.
6. Interaja com o sistema utilizando o menu numérico exibido no console.

---
