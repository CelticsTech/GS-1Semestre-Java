# 🛰️🌱 CelticsTech API

<div align="center">

Sistema inteligente para apoio ao agronegócio com recomendações de cultivo, irrigação e colheita.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-green)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-brightgreen)
![H2](https://img.shields.io/badge/Database-H2-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-purple)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

</div>

---

# 📖 Sobre o Projeto

A **CelticsTech API** foi desenvolvida para auxiliar agricultores e associações rurais no gerenciamento de cultivos e recomendações agrícolas.

A solução conecta tecnologia, dados e agronegócio para apoiar decisões relacionadas a:

- 🌱 Plantio
- 💧 Irrigação
- 🌾 Colheita
- 🌦️ Recomendações climáticas
- 🛰️ Apoio ao agronegócio conectado ao tema da economia espacial

---

# 🚀 Tecnologias Utilizadas

```txt
Java 21
Spring Boot
Spring Web
Spring Data JPA
Hibernate
H2 Database
Maven
Lombok
Swagger / OpenAPI
Spring Cache
Bean Validation
HATEOAS
JWT
```

---

# 📁 Estrutura do Projeto

```bash
src/main/java/com/globalsolution/java/celticstech
│
├── controller
├── service
├── repository
├── models
├── dto
│   ├── request
│   └── response
├── enums
├── exceptions
├── validation
└── config
```

---

# 🗄️ Banco de Dados

O projeto utiliza o banco **H2 em memória**.

## 🔗 H2 Console

```txt
http://localhost:8080/h2-console
```

## ⚙️ Configuração

```txt
JDBC URL: jdbc:h2:mem:celticstechdb
User: sa
Password:
```

---

# 📚 Swagger

Documentação interativa da API:

```txt
http://localhost:8080/swagger-ui/index.html
```

---

# 🔐 Autenticação

A API possui autenticação com JWT utilizando o login da associação.

## Login

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/auth/login` | Realizar login |

### Request

```json
{
  "login": "arp",
  "senha": "123456"
}
```

### Response

```json
{
  "token": "eyJhbGciOi..."
}
```

---

# 🌾 Endpoints - Agricultores

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/agricultores` | Criar agricultor |
| GET | `/agricultores` | Listar agricultores |
| GET | `/agricultores/{id}` | Buscar agricultor por ID com HATEOAS |
| PUT | `/agricultores/{id}` | Atualizar agricultor |
| DELETE | `/agricultores/{id}` | Deletar agricultor |

---

# 🌱 Endpoints - Cultivos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/cultivos` | Criar cultivo |
| GET | `/cultivos` | Listar cultivos |
| GET | `/cultivos/{id}` | Buscar cultivo por ID com HATEOAS |
| PUT | `/cultivos/{id}` | Atualizar cultivo |
| DELETE | `/cultivos/{id}` | Deletar cultivo |

---

# 🗺️ Endpoints - Regiões

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/regioes` | Criar região |
| GET | `/regioes` | Listar regiões |
| GET | `/regioes/{id}` | Buscar região por ID |
| PUT | `/regioes/{id}` | Atualizar região |
| DELETE | `/regioes/{id}` | Deletar região |

---

# 🏢 Endpoints - Associações

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/associacoes` | Criar associação |
| GET | `/associacoes` | Listar associações |
| GET | `/associacoes/{id}` | Buscar associação por ID |
| PUT | `/associacoes/{id}` | Atualizar associação |
| DELETE | `/associacoes/{id}` | Deletar associação |

---

# ☎️ Endpoints - Contatos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/contatos` | Criar contato |
| GET | `/contatos` | Listar contatos |
| GET | `/contatos/{id}` | Buscar contato por ID |
| PUT | `/contatos/{id}` | Atualizar contato |
| DELETE | `/contatos/{id}` | Deletar contato |

---

# 📌 Endpoints - Recomendações

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/recomendacoes` | Criar recomendação |
| GET | `/recomendacoes` | Listar recomendações |
| GET | `/recomendacoes/{id}` | Buscar recomendação por ID |
| GET | `/recomendacoes/associacao/{id}` | Buscar recomendações por associação |
| GET | `/recomendacoes/cultivo/{id}` | Buscar recomendações por cultivo |
| GET | `/recomendacoes/tipo/{tipo}` | Buscar recomendações por tipo |
| PUT | `/recomendacoes/{id}` | Atualizar recomendação |
| DELETE | `/recomendacoes/{id}` | Deletar recomendação |

---

# 🔗 Endpoints - Relacionamentos

## Agricultor ↔ Cultivo

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/agricultores/{idAgricultor}/cultivos/{idCultivo}` | Vincular cultivo ao agricultor |
| GET | `/agricultores/{idAgricultor}/cultivos` | Listar cultivos do agricultor |
| DELETE | `/agricultores/{idAgricultor}/cultivos/{idCultivo}` | Remover vínculo |

## Associação ↔ Agricultor

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/associacoes/{idAssociacao}/agricultores/{idAgricultor}` | Vincular agricultor à associação |
| GET | `/associacoes/{idAssociacao}/agricultores` | Listar agricultores da associação |
| DELETE | `/associacoes/{idAssociacao}/agricultores/{idAgricultor}` | Remover vínculo |

---

# 📊 Modelagem Avançada

### 🔹 Chave Composta

```txt
AgricultorCultivoId
AssociacaoAgricultorId
```

### 🔹 Embedded

```txt
AuditoriaModels
```

### 🔹 Relacionamentos

```txt
Região → Associação

Associação → Região

Associação ↔ Agricultor

Agricultor ↔ Cultivo

Recomendação → Associação

Recomendação → Cultivo
```

---

# 🔗 HATEOAS

A API utiliza HATEOAS em endpoints de busca por ID.

Exemplo:

```txt
GET /agricultores/{id}
GET /cultivos/{id}
```

Retornando links relacionados ao próprio recurso e a outras ações disponíveis.

---

# ⚡ Cache

Utilizando:

```java
@Cacheable
@CacheEvict
```

Caches implementados:

```txt
agricultores
agricultoresById
cultivos
cultivosById
regioes
regioesById
associacoes
associacoesById
contatos
contatosById
recomendacoes
recomendacoesById
```

---

# 🔐 Validações

```txt
@NotBlank
@NotNull
@Size
@Email
@Min
@Pattern
@CNPJ
```

### Validação Personalizada

```java
@TelefoneBR
```

---

# ⚠️ Tratamento Global de Exceções

Implementado com:

```java
@RestControllerAdvice
```

Tratando:

```txt
ResourceNotFoundException
BusinessException
Validation Errors
Enum Conversion Errors
```

---

# 📄 Paginação

```http
GET /agricultores?page=0&size=5
```

```http
GET /cultivos?page=0&size=10
```

---

# 📌 Exemplos de Request

## Criar Agricultor

```json
{
  "nomeAgricultor": "João Silva",
  "idade": 35,
  "sexo": "M",
  "qtdeDependentes": 2
}
```

## Criar Região

```json
{
  "nomeRegiao": "Sudeste",
  "ufRegiao": "SP"
}
```

## Criar Associação

```json
{
  "nomeAssociacao": "Associação Rural Paulista",
  "siglaAssociacao": "ARP",
  "cnpj": "11222333000181",
  "login": "arp",
  "senha": "123456",
  "idRegiao": 1
}
```

## Criar Cultivo

```json
{
  "nomeCultivo": "Milho",
  "categoriaCultivo": "Grãos",
  "porteCultivo": "HORTALICA",
  "tempoColheita": "120 dias",
  "vidaUtil": "1 ano",
  "intermitencia": "Semanal"
}
```

## Criar Recomendação

```json
{
  "dataRecAsc": "2026-05-29",
  "orientacao": "Realizar irrigação leve devido à baixa umidade do solo.",
  "tipoRecomendacao": "IRRIGACAO",
  "idAssociacao": 1,
  "idCultivo": 1
}
```

---

# 🧪 Como Executar

```bash
git clone https://github.com/CelticsTech/GS-1Semestre-Java.git
```

```bash
cd GS-1Semestre-Java
```

```bash
mvn spring-boot:run
```

---

# 🌐 Deploy

A aplicação encontra-se publicada na plataforma Render:

### 🔗 API Online

```txt
https://gs-1semestre-java-3.onrender.com
```

### 📚 Swagger Online

```txt
https://gs-1semestre-java-3.onrender.com/swagger-ui/index.html
```

### 🔍 OpenAPI JSON

```txt
https://gs-1semestre-java-3.onrender.com/v3/api-docs
```

> Observação: por utilizar o plano gratuito do Render, a aplicação pode levar alguns segundos para responder após períodos de inatividade.

---

---

# 🎥 Vídeo de Apresentação

Link do vídeo:

```txt
Adicionar link aqui
```

---

# 👨‍💻 Equipe

## CelticsTech

- Vinicius Romaguera Cardozo - RM 562308
- João Victor Vendrameto - RM 563665
- Nicolas de Oliveira Jacob - RM 564205
- Gabriel Ambrósio Saraiva - RM 566552
- Yuri Fuzinatto Garzoli Barreto - RM 561450

---

<div align="center">

## 🛰️🌱 CelticsTech

### Tecnologia espacial aplicada ao agronegócio inteligente

FIAP - Global Solution 2026

</div>****
