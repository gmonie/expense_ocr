# Expense OCR

Aplicación web para gestión de gastos y procesamiento automático de tickets mediante OCR.

## Descripción

Expense OCR es un proyecto full-stack cuyo objetivo es permitir a los usuarios registrar, visualizar y administrar gastos de manera sencilla. A futuro, la aplicación permitirá cargar fotografías de tickets para extraer automáticamente información utilizando OCR.

## Estado actual del proyecto

### Backend (Spring Boot)

* [x] Configuración inicial de Spring Boot
* [x] Conexión a PostgreSQL
* [x] Implementación de arquitectura por capas

  * Controller
  * Service
  * Repository
* [x] CRUD completo de gastos
* [x] DTOs (Request / Response)
* [x] Manejo global de excepciones
* [x] Configuración de CORS
* [x] Persistencia con Spring Data JPA

### Frontend (Next.js)

* [x] Configuración inicial de Next.js
* [x] Integración con Spring Boot API
* [x] Consumo de endpoint GET /api/expenses
* [x] Tabla de visualización de gastos
* [x] Formulario de creación de gastos
* [x] Tipado con TypeScript
* [x] Estilos con Tailwind CSS

### Próximas funcionalidades

* [ ] Actualizar gastos desde la interfaz
* [ ] Eliminar gastos desde la interfaz
* [ ] Búsqueda y filtrado de gastos
* [ ] Carga de tickets
* [ ] Integración con PaddleOCR
* [ ] Almacenamiento de imágenes en AWS S3
* [ ] Base de datos en AWS RDS
* [ ] Autenticación de usuarios
* [ ] Dashboard de estadísticas
* [ ] Deploy en producción

---

## Arquitectura

```text

Next.js/Frontend -- HTTP --> Spring Boot/Backend -- JPA --> PostgreSQL/Database

```

---

## Endpoints disponibles

### Crear gasto

```http
POST /api/expenses
```

Body:

```json
{
  "store": "Walmart",
  "amount": 350.75,
  "purchaseDate": "2026-06-12",
  "category": "Groceries"
}
```

---

### Obtener todos los gastos

```http
GET /api/expenses
```

---

### Obtener gasto por ID

```http
GET /api/expenses/{id}
```

---

### Actualizar gasto

```http
PUT /api/expenses/{id}
```

---

### Eliminar gasto

```http
DELETE /api/expenses/{id}
```

---

## Estructura del proyecto

```text
expense-ocr/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── dto/
│   ├── exception/
│   └── config/
│
└── frontend/
    └── src/
        ├── app/
        ├── components/
        ├── services/
        └── types/
```

---

## Tecnologías utilizadas

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

### Frontend

* Next.js
* React
* TypeScript
* Tailwind CSS

### Herramientas

* Git
* GitHub
* Postman
* IntelliJ IDEA

### Próximamente

* PaddleOCR
* AWS S3
* AWS RDS
* Vercel
* Render

---

## Convenciones de Commits

Este proyecto utiliza el estándar **Conventional Commits**.

### Nuevas funcionalidades

```bash
git commit -m "feat(archivo): Se agregó el endpoint para actualizar el gasto."
```

### Corrección de errores

```bash
git commit -m "fix(archivo): Regresa 404 cuando el gasto no es encontrado."
``` 
Regresa 404 cuando el gasto no es encontrado

### Documentación

```bash
git commit -m "docs(Archivo): Actualización del README."
```
Actualización del README
### Refactorización

```bash
git commit -m "refactor(Archivo): Refactorización del mapping del servicio expense."
```

### Pruebas

```bash
git commit -m "test(Archivo): Se agregó el test para el controlled de expense."
```

---

## Objetivos de aprendizaje

Este proyecto tiene como propósito practicar:

* Desarrollo Backend con Spring Boot
* APIs REST
* PostgreSQL y JPA/Hibernate
* Desarrollo Frontend con Next.js
* Arquitectura por capas
* Integración Frontend ↔ Backend
* OCR con PaddleOCR
* Servicios Cloud en AWS
* Buenas prácticas de Git y documentación técnica

---

## Roadmap

### Fase 1 — Backend CRUD ✅

* [x] Entidad Expense
* [x] CRUD completo
* [x] PostgreSQL
* [x] Manejo de excepciones

### Fase 2 — Frontend MVP 🚧

* [x] Conexión Next.js ↔ Spring Boot
* [x] Tabla de gastos
* [x] Formulario de creación
* [ ] Edición de gastos
* [ ] Eliminación de gastos

### Fase 3 — OCR

* [ ] Subida de tickets
* [ ] Procesamiento con PaddleOCR
* [ ] Extracción automática de datos

### Fase 4 — AWS

* [ ] Almacenamiento en S3
* [ ] PostgreSQL en RDS
* [ ] Deploy del backend
* [ ] Deploy del frontend

### Fase 5 — Producción

* [ ] Autenticación
* [ ] Dashboard
* [ ] Reportes
* [ ] Métricas de gastos
* [ ] Optimización y monitoreo

```
```
