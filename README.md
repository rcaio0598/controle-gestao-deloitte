# Controle de Gestão (CRUD) - Bootcamp

![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-1.0-green)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow)


## 📌 Sobre o projeto
Projeto desenvolvido durante o Bootcamp para praticar lógica de programação em Java.  
O sistema é um CRUD simples (Create, Read, Update, Delete) executado via console, que permite gerenciar registros básicos.

---

## 🎯 Objetivo
O objetivo é consolidar o uso de:

- Variáveis dos tipos `int`, `String` e `boolean`
- Estruturas condicionais (`if`, `else`)
- Estruturas de repetição (`for`, `while`)
- Operações básicas de CRUD

---

## ⚙️ Funcionalidades
- Cadastrar um novo registro
- Consultar registros existentes
- Atualizar registros
- Deletar registros

---

## 🧱 Estrutura do registro
Cada registro contém:

| Campo | Tipo | Descrição |
|------|------|-----------|
| `id` | `int` | Identificador do registro |
| `nome` | `String` | Nome do registro |
| `ativo` | `boolean` | Indica se o registro está ativo |

---

## 🚀 Como executar
1. Abra o projeto no IntelliJ IDEA
2. Execute a classe `ControleGestao`
3. Siga o menu no console

---

## 📌 Observações
- Projeto inicial voltado para prática de lógica.
- Pode ser melhorado com persistência de dados e validações.

---

## 🧾 Versão
- **1.0** — Versão inicial com CRUD básico via console

## Uso do git reset

Durante o desenvolvimento, foi criado um arquivo `senha.txt` com conteúdo fictício e realizado um commit propositalmente. Após isso, foi necessário remover esse arquivo do último commit sem perder as demais alterações.

### Diferença entre os tipos de reset

- **git reset --soft**: desfaz o commit, mas mantém todas as alterações no stage.
- **git reset --mixed**: desfaz o commit e remove os arquivos do stage, mantendo apenas no working directory.
- **git reset --hard**: desfaz o commit e apaga completamente as alterações, podendo causar perda de código.

### Justificativa da escolha

O comando `git reset --soft` foi escolhido porque permite desfazer o último commit sem perder as alterações realizadas, possibilitando remover apenas o arquivo sensível antes de criar um novo commit limpo. Os outros tipos de reset não eram adequados, pois o `--mixed` exigiria novo staging desnecessário e o `--hard` poderia causar perda de código.

