# 🛰️🌱 CelticsTech API

<div align="center">

Sistema inteligente para apoio ao agronegócio com recomendações de cultivo, irrigação e colheita.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-green)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-brightgreen)
![H2](https://img.shields.io/badge/Database-H2-blue)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

</div>

---

# 📖 Sobre o Projeto

A **CelticsTech API** foi desenvolvida para auxiliar agricultores e associações rurais no gerenciamento de cultivos e recomendações agrícolas.

A solução tem como foco o uso de tecnologia para apoiar decisões relacionadas a:

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
📁 Estrutura do Projeto
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
🗄️ Banco de Dados

O projeto utiliza o banco H2 em memória.

🔗 H2 Console
http://localhost:8080/h2-console
⚙️ Configuração
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password:
📚 Swagger

Documentação interativa da API:

http://localhost:8080/swagger-ui/index.html
🌾 Endpoints - Agricultores
Método	Endpoint	Descrição
POST	/agricultores	Criar agricultor
GET	/agricultores	Listar agricultores
GET	/agricultores/{id}	Buscar agricultor por ID
PUT	/agricultores/{id}	Atualizar agricultor
DELETE	/agricultores/{id}	Deletar agricultor
🌱 Endpoints - Cultivos
Método	Endpoint	Descrição
POST	/cultivos	Criar cultivo
GET	/cultivos	Listar cultivos
GET	/cultivos/{id}	Buscar cultivo por ID
PUT	/cultivos/{id}	Atualizar cultivo
DELETE	/cultivos/{id}	Deletar cultivo
🗺️ Endpoints - Regiões
Método	Endpoint	Descrição
POST	/regioes	Criar região
GET	/regioes	Listar regiões
GET	/regioes/{id}	Buscar região por ID
PUT	/regioes/{id}	Atualizar região
DELETE	/regioes/{id}	Deletar região
🏢 Endpoints - Associações
Método	Endpoint	Descrição
POST	/associacoes	Criar associação
GET	/associacoes	Listar associações
GET	/associacoes/{id}	Buscar associação por ID
PUT	/associacoes/{id}	Atualizar associação
DELETE	/associacoes/{id}	Deletar associação
☎️ Endpoints - Contatos
Método	Endpoint	Descrição
POST	/contatos	Criar contato
GET	/contatos	Listar contatos
GET	/contatos/{id}	Buscar contato por ID
PUT	/contatos/{id}	Atualizar contato
DELETE	/contatos/{id}	Deletar contato
📌 Endpoints - Recomendações
Método	Endpoint	Descrição
POST	/recomendacoes	Criar recomendação
GET	/recomendacoes	Listar recomendações
GET	/recomendacoes/{id}	Buscar recomendação por ID
GET	/recomendacoes/associacao/{id}	Buscar recomendações por associação
GET	/recomendacoes/cultivo/{id}	Buscar recomendações por cultivo
GET	/recomendacoes/tipo/{tipo}	Buscar recomendações por tipo
PUT	/recomendacoes/{id}	Atualizar recomendação
DELETE	/recomendacoes/{id}	Deletar recomendação
🔗 Endpoints - Relacionamentos
Agricultor ↔ Cultivo
Método	Endpoint	Descrição
POST	/agricultores/{idAgricultor}/cultivos/{idCultivo}	Vincular cultivo ao agricultor
GET	/agricultores/{idAgricultor}/cultivos	Listar cultivos do agricultor
DELETE	/agricultores/{idAgricultor}/cultivos/{idCultivo}	Remover vínculo
Associação ↔ Agricultor
Método	Endpoint	Descrição
POST	/associacoes/{idAssociacao}/agricultores/{idAgricultor}	Vincular agricultor à associação
GET	/associacoes/{idAssociacao}/agricultores	Listar agricultores da associação
DELETE	/associacoes/{idAssociacao}/agricultores/{idAgricultor}	Remover vínculo
🔗 Relacionamentos
Região → Associação
OneToMany / ManyToOne

Uma região pode possuir várias associações.

Associação ↔ Agricultor
ManyToMany

Uma associação pode possuir vários agricultores.

Agricultor ↔ Cultivo
Entidade associativa com chave composta

Relacionamento representado pela entidade:

AgricultorCultivo
Recomendação

Relaciona:

Associação
Cultivo
ManyToOne
📊 Modelagem Avançada

O projeto contempla recursos de modelagem avançada:

🔹 Chave Composta

Implementada em:

AgricultorCultivoId
AssociacaoAgricultorId
🔹 Embedded

Utilizado para auditoria:

AuditoriaModels
🔹 Múltiplas Tabelas

A aplicação possui entidades como:

Agricultor
Cultivo
Região
Associação
Contato
Recomendação
AgricultorCultivo
✅ Validações

O projeto utiliza Bean Validation:

@NotBlank
@NotNull
@Size
@Email
@Min
@Pattern
🔐 Validação Customizada

Foi criada uma validação personalizada para telefone brasileiro:

@TelefoneBR
✔️ Exemplo válido
11999999999
⚡ Cache

O projeto utiliza Spring Cache para otimizar consultas.

Utilizando
@Cacheable
@CacheEvict

Caches utilizados:

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
📄 Paginação

As listagens utilizam Pageable.

Exemplo
GET /agricultores?page=0&size=5
⚠️ Tratamento Global de Exceções

Implementado com:

@RestControllerAdvice

Tratando:

ResourceNotFoundException
BusinessException
Erros de validação
Erros de conversão de Enum
📌 Exemplos de Request
Criar Agricultor
POST /agricultores
{
  "nomeAgricultor": "João Silva",
  "idade": 35,
  "sexo": "M",
  "qtdeDependentes": 2
}
Criar Região
POST /regioes
{
  "nomeRegiao": "Sudeste",
  "ufRegiao": "SP"
}
Criar Cultivo
POST /cultivos
{
  "nomeCultivo": "Milho",
  "categoriaCultivo": "Grãos",
  "porteCultivo": "HORTALICA",
  "tempoColheita": "120 dias",
  "vidaUtil": "1 ano",
  "intermitencia": "Semanal"
}
Criar Associação
POST /associacoes
{
  "nomeAssociacao": "Associação Rural Paulista",
  "siglaAssociacao": "ARP",
  "cnpj": "11222333000181",
  "login": "arp",
  "senha": "123456",
  "idRegiao": 1
}
Criar Recomendação
POST /recomendacoes
{
  "dataRecAsc": "2026-05-29",
  "orientacao": "Realizar irrigação leve devido à baixa umidade do solo.",
  "tipoRecomendacao": "IRRIGACAO",
  "idAssociacao": 1,
  "idCultivo": 1
}
🧪 Como Executar
git clone https://github.com/CelticsTech/GS-1Semestre-Java.git
cd GS-1Semestre-Java
mvn spring-boot:run
👨‍💻 Autores
CelticsTech
Vinicius Romaguera Cardozo - RM 562308 - 2TDSPX
Integrante 2
Integrante 3
Integrante 4
Integrante 5
<div align="center">
🛰️🌱 CelticsTech
Tecnologia espacial aplicada ao agronegócio inteligente.
</div> ```
