# 🎓 Sistema Acadêmico

Um sistema acadêmico desenvolvido em **Java** utilizando os conceitos de **Programação Orientada a Objetos (POO)**. O projeto permite gerenciar alunos, disciplinas, matrículas e notas por meio de um menu interativo no terminal.

## 📋 Funcionalidades

- Cadastro de alunos
- Cadastro de disciplinas
- Matrícula de alunos em disciplinas
- Lançamento de notas
- Cálculo da média do aluno
- Emissão de boletim
- Salvamento dos dados em arquivos `.txt`
- Carregamento automático dos dados ao iniciar o sistema

## ✔️ Validações implementadas

O sistema possui algumas validações para garantir a integridade dos dados:

- Não permite matrícula duplicada do mesmo aluno na mesma disciplina.
- Não permite lançar notas menores que **0** ou maiores que **10**.
- Validação de IDs de alunos, disciplinas e matrículas para evitar acessos inválidos.

## 💾 Persistência de dados

Os dados são armazenados em arquivos de texto (`.txt`), permitindo que as informações permaneçam salvas mesmo após o encerramento da aplicação.

Arquivos utilizados:

- `alunos.txt`
- `disciplinas.txt`
- `matriculas.txt`

Ao iniciar o sistema, os dados são carregados automaticamente desses arquivos.

## 📂 Estrutura do projeto

```text
SistemaAcademico/
│
├── Main.java
├── SistemaAcademico.java
├── Aluno.java
├── Disciplina.java
├── Matricula.java
├── Arquivo.java
│
├── alunos.txt
├── disciplinas.txt
└── matriculas.txt
```

## 🛠️ Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections (`ArrayList`)
- Manipulação de arquivos (`FileReader`, `BufferedReader`, `FileWriter` e `BufferedWriter`)

## ▶️ Como executar

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Abra o projeto em sua IDE de preferência (IntelliJ IDEA, Eclipse ou VS Code).

3. Execute a classe `Main.java`.

4. Utilize o menu exibido no terminal para gerenciar os dados do sistema.

## 📖 Objetivo

Este projeto foi desenvolvido com fins de estudo da linguagem Java e dos conceitos de Programação Orientada a Objetos, incluindo encapsulamento, organização em classes, manipulação de coleções, validações e persistência de dados em arquivos de texto.
