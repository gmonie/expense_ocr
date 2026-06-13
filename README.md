# Expense OCR

Aplicación web para digitalizar tickets de compra utilizando OCR (Detección de texto en imágenes), almacenar gastos en PostgreSQL y visualizar/gestionar la información mediante una interfaz web.

---

# Objetivo del proyecto

Construir una aplicación full-stack que permita:

* Subir imágenes de tickets de compra.
* Extraer información mediante OCR (PaddleOCR).
* Almacenar gastos en PostgreSQL.
* Gestionar gastos mediante una API REST.
* Desplegar servicios utilizando AWS.
* Visualizar gastos desde una interfaz web.

---

# Arquitectura actual

```text
Frontend (Next.js)
        │
        ▼
Spring Boot REST API
        │
        ▼
PostgreSQL
```

---

# Stack tecnológico

## Backend

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok

## Base de datos

* PostgreSQL

## Frontend (próximamente)

* Next.js
* React
* TypeScript

## OCR (próximamente)

* PaddleOCR

## Cloud (próximamente)

* AWS S3
* AWS RDS
* AWS EC2 / ECS

---

# Funcionalidades implementadas

## Gestión de gastos

Entidad principal:

```java
Expense
```

### Campos

| Campo        | Tipo       |
| ------------ | ---------- |
| id           | UUID       |
| store        | String     |
| amount       | BigDecimal |
| purchaseDate | LocalDate  |
| category     | String     |

---

# API REST

## Obtener todos los gastos

```http
GET /api/expenses
```

### Respuesta

```json
[
  {
    "id": "uuid",
    "store": "OXXO",
    "amount": 120.50,
    "purchaseDate": "2026-06-04",
    "category": "Food"
  }
]
```

---

## Obtener gasto por ID

```http
GET /api/expenses/{id}
```

---

## Crear gasto

```http
POST /api/expenses
```

### Body

```json
{
  "store": "OXXO",
  "amount": 120.50,
  "purchaseDate": "2026-06-04",
  "category": "Food"
}
```

---

## Eliminar gasto

```http
DELETE /api/expenses/{id}
```

---

# Manejo de errores

## ExpenseNotFoundException

Se lanza cuando un gasto solicitado no existe.

### Ejemplo

```http
GET /api/expenses/00000000-0000-0000-0000-000000000000
```

### Respuesta

```http
404 Not Found
```

```text
Expense not found with id: 00000000-0000-0000-0000-000000000000
```

---

## GlobalExceptionHandler

Las excepciones se gestionan centralizadamente mediante:

```java
@RestControllerAdvice
```

---

# Estructura actual del backend

```text
src/main/java/com/ximena/expenseocr

├── controller
│   └── ExpenseController
│
├── dto
│   ├── ExpenseRequest
│   └── ExpenseResponse
│
├── entity
│   └── Expense
│
├── exception
│   ├── ExpenseNotFoundException
│   └── GlobalExceptionHandler
│
├── repository
│   └── ExpenseRepository
│
├── service
│   ├── ExpenseService
│   └── ExpenseServiceImpl
│
└── ExpenseOcrApplication
```

---

# Cómo ejecutar el proyecto

## Requisitos

* Java 21
* Maven 3.9+
* PostgreSQL 16+

Verificar instalación:

```bash
java --version
mvn --version
psql --version
```

---

## Configuración de PostgreSQL

Crear la base de datos:

```sql
CREATE DATABASE expense_ocr;
```

---

## Configuración de Spring Boot

Archivo:

```text
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/expense_ocr
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Ejecutar backend

```bash
./mvnw spring-boot:run
```

o

```bash
mvn spring-boot:run
```

---

# Pruebas rápidas con curl

## Crear gasto

```bash
curl -X POST http://localhost:8080/api/expenses \
-H "Content-Type: application/json" \
-d '{
  "store":"OXXO",
  "amount":120.50,
  "purchaseDate":"2026-06-04",
  "category":"Food"
}'
```

---

## Obtener todos los gastos

```bash
curl http://localhost:8080/api/expenses
```

---

## Obtener gasto por ID

```bash
curl http://localhost:8080/api/expenses/{id}
```

---

## Eliminar gasto

```bash
curl -X DELETE http://localhost:8080/api/expenses/{id}
```

---

# Roadmap

## Fase 1 - Backend CRUD

* [x] Crear gastos
* [x] Obtener gastos
* [x] Obtener gasto por ID
* [x] Eliminar gastos
* [ ] Actualizar gastos

## Fase 2 - Frontend

* [ ] Listado de gastos
* [ ] Formulario de creación
* [ ] Consumo de API REST

## Fase 3 - OCR

* [ ] Subida de tickets
* [ ] Integración con PaddleOCR
* [ ] Extracción automática de datos

## Fase 4 - AWS

* [ ] AWS S3 para imágenes
* [ ] AWS RDS PostgreSQL
* [ ] Despliegue backend
* [ ] Despliegue frontend

---

# Convención de commits

Este proyecto utiliza el estándar **Conventional Commits**, ampliamente adoptado en la industria para:

* Mantener un historial consistente.
* Automatizar changelogs.
* Facilitar versionado semántico.
* Mejorar procesos CI/CD.

## Formato

```text
<tipo>: <descripción>
```

### Ejemplos

```text
feat: add expense creation endpoint
fix: handle expense not found exception
docs: update README installation guide
refactor: simplify expense mapping logic
test: add expense service unit tests
```

---

## Tipos de commit

| Tipo     | Descripción                  |
| -------- | ---------------------------- |
| feat     | Nueva funcionalidad          |
| fix      | Corrección de errores        |
| docs     | Documentación                |
| refactor | Refactorización              |
| test     | Pruebas                      |
| style    | Formato de código            |
| chore    | Tareas de mantenimiento      |
| build    | Dependencias o configuración |
| ci       | Integración continua         |

---

## Ejemplos utilizados en este proyecto

### Crear entidad

```bash
git commit -m "feat: create expense entity"
```

### Crear repositorio

```bash
git commit -m "feat: add expense repository"
```

### Implementar servicio

```bash
git commit -m "feat: implement expense service"
```

### Crear controlador

```bash
git commit -m "feat: add expense controller"
```

### Manejo global de excepciones

```bash
git commit -m "feat: add global exception handling"
```

### Actualizar documentación

```bash
git commit -m "docs: add project setup instructions"
```

### Corregir bug

```bash
git commit -m "fix: return 404 when expense is not found"
```

### Refactorizar código

```bash
git commit -m "refactor: extract expense mapping logic"
```

---

# Próximo objetivo

Completar el CRUD implementando:

```http
PUT /api/expenses/{id}
```

y posteriormente integrar el frontend con Next.js para visualizar y administrar gastos desde la interfaz web.
