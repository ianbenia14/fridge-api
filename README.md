# Fridge API

API REST para gerenciar alimentos na geladeira.

## Tecnologias
- Java 17+
- Spring Boot
- H2 Database
- JPA/Hibernate

## Como rodar
1. Clone o repositório
2. Execute: `mvn spring-boot:run`
3. Acesse: `http://localhost:8080/food`

## Endpoints
- GET `/food` - Listar todos
- POST `/food` - Criar novo
- DELETE `/food/{id}` - Deletar

## Console H2
`http://localhost:8080/h2-console`
