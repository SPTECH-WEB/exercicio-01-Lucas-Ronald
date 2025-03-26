[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/RzxyCqmH)
# 📘 Exercício – API de Faturas com Validação de Dados

## 🧾 Descrição

Este projeto tem como objetivo criar uma **API REST em Spring Boot** para o cadastro de **faturas de cartão de crédito**, aplicando validações nos dados com **Java Bean Validation**. O exercício é voltado para iniciantes que desejam aprender como garantir a integridade dos dados recebidos por uma API utilizando as anotações de validação do Jakarta Bean Validation.

---

## 🎯 Objetivos

- Criar uma entidade `Fatura` com validações automáticas usando anotações como `@NotBlank`, `@Size`, `@Pattern`, `@DecimalMin`, `@FutureOrPresent`, `@Email`, entre outras.
- Desenvolver endpoints REST para cadastrar (`POST`) e listar (`GET`) faturas.
- Testar os comportamentos de validação ao enviar dados válidos e inválidos.
- Observar como o Spring Boot retorna mensagens de erro automaticamente, sem necessidade de tratamento manual.

---

## 🧱 Estrutura esperada da entidade `Fatura`

| Campo           | Tipo       | Validação                                                                 |
|------------------|------------|---------------------------------------------------------------------------|
| `id`             | `Long`     | Gerado automaticamente (`@Id`)                                           |
| `numeroCartao`   | `String`   | Obrigatório. Deve conter **exatamente 16 dígitos numéricos**             |
| `nomeTitular`    | `String`   | Obrigatório. Entre **3 e 100 caracteres**                                 |
| `valor`          | `Double`   | Obrigatório. Mínimo **10.00**, máximo **5000.00**                         |
| `dataPagamento`  | `LocalDate`| Obrigatória. Deve ser uma data **presente ou futura**                    |
| `emailContato`   | `String`   | Obrigatório. Deve ser um **e-mail válido**                               |

---

## 🚀 Endpoints da API

| Método | Endpoint      | Descrição                    |
|--------|----------------|------------------------------|
| POST   | `/faturas`     | Cadastra uma nova fatura     |
| GET    | `/faturas`     | Lista todas as faturas       |

---

## 🛠 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation (Jakarta)
- H2 Database
- Lombok
- Maven

---

## 🧪 Testes com Insomnia/Postman

1. Teste o endpoint `POST /faturas` com:
   - Dados válidos ✅
   - Dados inválidos ❌ (ex: e-mail errado, valor abaixo de 10, cartão com menos de 16 dígitos etc.)

2. Observe como a resposta da API exibe automaticamente as mensagens de erro, como neste exemplo:

```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "errors": [
    {
      "field": "numeroCartao",
      "message": "Deve conter exatamente 16 dígitos numéricos."
    },
    {
      "field": "emailContato",
      "message": "O e-mail deve ser válido."
    }
  ]
}

