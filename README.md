# 📊 Sistema de Controle de Gestão (CRUD)

> Aplicação console Java para gerenciamento de usuários, desenvolvida como atividade avaliativa do **Bootcamp Java - Deloitte**.

[![Java](https://img.shields.io/badge/Java-17+-orange)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Educational-blue)]()

---

## 🎯 Sobre o Projeto

Sistema CRUD (Create, Read, Update, Delete) desenvolvido em Java para consolidar fundamentos de programação orientada a objetos e lógica de programação durante o Bootcamp Java da Deloitte.

O sistema permite gerenciar registros de usuários através de um menu interativo no console, aplicando conceitos de:
- Estruturas de dados (ArrayList)
- Estruturas condicionais e de repetição
- Programação orientada a objetos
- Encapsulamento e boas práticas

---

## ✨ Funcionalidades

- ✅ **Cadastrar** novo usuário
- ✅ **Listar** todos os usuários cadastrados
- ✅ **Buscar** usuário por ID
- ✅ **Atualizar** informações de usuário
- ✅ **Ativar/Desativar** usuário (soft delete)
- ✅ **Deletar** usuário permanentemente

---

## 🚀 Como Executar

### Pré-requisitos

- **Java JDK 11** ou superior instalado
- IDE Java (IntelliJ IDEA, Eclipse, VS Code com Java Extension Pack)

### Passo a Passo

**1. Clone o repositório:**
```bash
git clone https://github.com/rcaio0598/controle-gestao-deloitte.git
cd controle-gestao-deloitte
```

**2. Compile o projeto:**
```bash
# Na raiz do projeto
javac -d bin src/main/java/com/caio/controlegestao/*.java
```

**3. Execute a aplicação:**
```bash
java -cp bin com.caio.controlegestao.ControleGestao
```

**OU use sua IDE:**
- Abra o projeto na IDE
- Execute a classe `ControleGestao.java`
- Interaja através do console

---

## 📂 Estrutura do Projeto
```
controle-gestao-deloitte/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── caio/
│                   └── controlegestao/
│                       ├── ControleGestao.java    # Classe principal (menu e CRUD)
│                       └── Usuario.java           # Modelo de dados
├── .gitignore
└── README.md
```

---

## 🧱 Modelo de Dados

### Classe Usuario

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| `id` | `int` | Identificador único do usuário |
| `nome` | `String` | Nome completo do usuário |
| `ativo` | `boolean` | Status do usuário (true = ativo, false = inativo) |

**Métodos principais:**
- `getId()`, `setId(int)`
- `getNome()`, `setNome(String)`
- `isAtivo()`, `ativar()`, `desativar()`
- `toString()` - Formatação para exibição

---

## 💡 Conceitos Aplicados

### Programação Orientada a Objetos
- ✅ Encapsulamento (atributos privados + getters/setters)
- ✅ Classe de modelo (Usuario) separada da lógica (ControleGestao)
- ✅ Sobrescrita de método (`toString()`)

### Estruturas de Dados
- ✅ `ArrayList<Usuario>` para armazenamento dinâmico

### Controle de Fluxo
- ✅ `switch-case` para menu de opções
- ✅ `for-each` para iteração
- ✅ `if-else` para validações

### Boas Práticas
- ✅ Organização em packages
- ✅ Nomenclatura descritiva
- ✅ Validação de entrada do usuário
- ✅ Tratamento básico de erros

---

## 🎓 Aprendizados

Durante o desenvolvimento deste projeto, consolidei:

- ✅ Sintaxe e estruturas fundamentais do Java
- ✅ Manipulação de coleções (`ArrayList`)
- ✅ Entrada e saída de dados via console (`Scanner`)
- ✅ Conceitos de POO na prática
- ✅ Organização de código em packages
- ✅ Versionamento com Git e GitHub

---

## 🔄 Possíveis Melhorias

- [ ] Persistência de dados (banco de dados ou arquivos)
- [ ] Validações mais robustas (CPF, email, etc)
- [ ] Testes unitários (JUnit)
- [ ] Interface gráfica (Swing/JavaFX)
- [ ] API REST (Spring Boot)
- [ ] Sistema de autenticação

---

## 📝 Licença

Projeto desenvolvido para fins educacionais durante o **Bootcamp Java - Deloitte**.

---

## 👤 Autor

**Caio Ruan Oliveira Nascimento**

- 🎓 Graduado em Ciência da Computação | Pós-graduando em Cibersecurity
- 💼 Participante do Bootcamp Java - Deloitte
- 🔗 GitHub: [@rcaio0598](https://github.com/rcaio0598)
- 💼 LinkedIn: [Caio Nascimento](https://www.linkedin.com/in/caionascimentoo/)

---

**Desenvolvido como atividade avaliativa do Bootcamp Java - Deloitte**
```

5. Commit:
```
docs: reescreve README com documentação completa do projeto
