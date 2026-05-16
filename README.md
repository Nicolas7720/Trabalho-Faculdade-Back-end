# 🛒 NcShop — API REST de Loja Virtual

Projeto desenvolvido como **Atividade Prática** da disciplina de Desenvolvimento Web Back-End na **UNINTER — Engenharia de Software**.

A NcShop é uma loja virtual fictícia. O sistema foi criado para gerenciar **Clientes**, **Produtos** e **Pedidos**, com operações completas de CRUD via API REST.

---

## 🚀 Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Docker / Docker Compose**
- **Postman** (testes)

---

## 🏗️ Arquitetura

A API segue o padrão de separação em camadas:

```
Controller → Service → Repository
```

- **Controller** — recebe e responde as requisições HTTP
- **Service** — contém as regras de negócio
- **Repository** — comunicação com o banco de dados

---

## 📋 Endpoints

### 👤 Cliente — `/clientes/v1`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/clientes/v1` | Cadastrar novo cliente |
| GET | `/clientes/v1` | Listar todos os clientes |
| GET | `/clientes/v1/{id}` | Buscar cliente por ID |
| GET | `/clientes/v1/search/{nome}` | Buscar cliente por nome |
| PUT | `/clientes/v1/{id}` | Atualizar cliente |
| DELETE | `/clientes/v1/{id}` | Remover cliente |

### 📦 Produto — `/produtos/v1`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/produtos/v1` | Cadastrar novo produto |
| GET | `/produtos/v1` | Listar todos os produtos |
| GET | `/produtos/v1/{id}` | Buscar produto por ID |
| GET | `/produtos/v1/search/{nome}` | Buscar produto por nome |
| PUT | `/produtos/v1/{id}` | Atualizar produto |
| DELETE | `/produtos/v1/{id}` | Remover produto |

### 🧾 Pedido — `/pedidos/v1`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/pedidos/v1` | Criar novo pedido |
| GET | `/pedidos/v1` | Listar todos os pedidos |
| GET | `/pedidos/v1/{id}` | Buscar pedido por ID |
| PUT | `/pedidos/v1/{id}` | Atualizar pedido |
| DELETE | `/pedidos/v1/{id}` | Remover pedido |

---

## 📝 Exemplos de Requisição

### Criar Cliente
```json
POST /clientes/v1
{
  "nome": "Nicolas"
}
```

### Criar Produto
```json
POST /produtos/v1
{
  "nome": "Extreme Shampoo",
  "preco": 6.00,
  "estoque": true
}
```

### Criar Pedido
```json
POST /pedidos/v1
{
  "clienteId": 1,
  "produtoId": 2,
  "quantidade": 5
}
```

---

## ✅ Regras de Negócio

- Não é permitido cadastrar clientes com nomes duplicados (case-insensitive)
- O preço do produto não pode ser negativo
- A quantidade de um pedido deve ser maior que zero
- Um pedido só pode ser criado se o cliente e o produto existirem

---

## 📡 Códigos HTTP Utilizados

| Código | Significado |
|--------|-------------|
| 200 | Sucesso |
| 201 | Recurso criado |
| 204 | Remoção bem-sucedida |
| 400 | Requisição inválida |
| 404 | Recurso não encontrado |
| 500 | Erro interno do servidor |

---

## ▶️ Como Rodar o Projeto

### Pré-requisitos
- Java 25+
- Docker e Docker Compose

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/Nicolas7720/Trabalho-Faculdade-Back-end
cd Trabalho-Faculdade-Back-end
```

2. Suba o banco de dados com Docker:
```bash
docker-compose up -d
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

4. Acesse a API em `http://localhost:8080`

---

## 👨‍💻 Autor

**Nicolas Antônio**  
Estudante de Engenharia de Software — UNINTER  
[![GitHub](https://img.shields.io/badge/GitHub-Nicolas7720-181717?logo=github)](https://github.com/Nicolas7720)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Nicolas%20Antônio-0A66C2?logo=linkedin)](https://br.linkedin.com/in/nicolasantonioa)
