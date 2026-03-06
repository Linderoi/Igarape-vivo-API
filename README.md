# 🌊 Igarapé Vivo API

API REST desenvolvida em Java com Spring Boot para simular o monitoramento do nível da água em áreas urbanas, classificando o risco de enchentes.

## 🚀 Tecnologias
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- REST API

## 📌 Funcionalidades
-Receber dados de sensores via POST.
-Listar todas as medições registradas via GET.
-Persistência em banco H2 em memória (fácil substituição por MySQL/PostgreSQL).
-Estrutura modular, pronta para evolução e deploy

## 🔧 Como executar o projeto
1. Clone o repositório
2. Abra no IntelliJ IDEA
3. Execute a classe `IgarapeVivoApiApplication`
4. Acesse `http://localhost:8080/monitoring`

## 📡 Endpoints

Método	URL	Parâmetros	Descrição
GET	/api/monitoring	-	Retorna todas as medições registradas
POST	/api/monitoring	sensorName, measurementValue	Cria uma nova medição

### POST /monitoring
POST http://localhost:8080/api/monitoring?sensorName=Sensor1&measurementValue=80

### RESPOSTA
{
  "sensorName": "Sensor1",
  "measurementValue": 80.0,
  "measurementTimestamp": "2026-03-02T17:18:32",
  "id": 1
}

## INSTALAÇÃO E EXECUÇÃO

Clone o repositório:

git clone https://github.com/Linderoi/Igarape-vivo-API/tree/main
cd igarape-vivo-api

Abra no IntelliJ IDEA como projeto Maven.

Compile e execute:

mvn clean install
mvn spring-boot:run

Acesse a API:

GET: http://localhost:8080/api/monitoring

H2 Console: http://localhost:8080/h2-console

H2 JDBC URL padrão: jdbc:h2:mem:igarape_vivo
Usuário: SA | Senha: (vazio)


## ESTRUTURA DO PROJETO
src/
 └─ main/java/com/igarapevivo/
     ├─ controller/MonitoringDataController.java
     ├─ model/MonitoringData.java
     ├─ repository/MonitoringDataRepository.java
     └─ IgarapeVivoApiApplication.java
src/main/resources/application.properties


### GET /monitoring
Lista todos os dados registrados.

## 🔗 Frontend

Interface da aplicação:

https://github.com/seu-usuario/igarape-vivo-frontend

## 👨‍💻 Autor
Projeto desenvolvido por mim atraves de um desafio da Alura (foco no back-end e lógica da aplicação).

Licença

MIT License © 2026 Linderoi
