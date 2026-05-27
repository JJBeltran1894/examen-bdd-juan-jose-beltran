# Examen Práctico - Taller de Desarrollo Backend

[cite_start]Este repositorio contiene la resolución del examen práctico utilizando Spring Boot, Hibernate/JPA y PostgreSQL para la gestión de vuelos[cite: 2, 4].

## 🎥 Video de Defensa Técnica
[cite_start]Puedes ver la explicación del proceso de guardado, la evidencia en base de datos y la consulta personalizada aquí[cite: 45, 46, 47, 48]:
[Ver video en Google Drive](https://drive.google.com/file/d/1qwY3DBMe5vPCVCN9JdckcRE-qt8qVIfR/view?usp=sharing)

---

## 📊 Parte 1: PostgreSQL Básico y Manipulación de Datos

### Creación de la Tabla `vuelos`

## 📊 Parte 2: Spring Boot API REST, Hibernate & JPA (El CRUD)

Este repositorio contiene la resolución del examen práctico utilizando Spring Boot, Hibernate/JPA y PostgreSQL para la gestión de vuelos.

controllers: Controladores REST para la exposición de Endpoints. 
entities: Clases de entidad mapeadas con JPA (Vuelo.java).  
repositories: Interfaces que extienden de JpaRepository.  
services: Capa de lógica de negocio de la aplicación.

## 🎥 Video de Defensa Técnica
Puedes ver la explicación del proceso de guardado, la base de datos y la consulta personalizada aquí:
[Ver video en Google Drive](https://drive.google.com/file/d/1qwY3DBMe5vPCVCN9JdckcRE-qt8qVIfR/view?usp=sharing)

---

## 🛠️ Parte 3: Modificación de Requisitos (Mantenimiento)

Para cumplir con el nuevo requisito de añadir el campo "destino" al sistema, se modificaron los siguientes archivos:

1. [cite_start]**`Vuelo.java` (Entidad):** Se añadió el atributo `destino` mapeado con `@Column(name = "destino", length = 100)`, además de actualizar los constructores y métodos Getters/Setters[cite: 67, 68].
2. [cite_start]**`VueloService.java` (Servicio):** Se ajustó el método de actualización (`actualizar`) para que tome en cuenta el nuevo campo `destino` al guardar[cite: 69].
3. [cite_start]**Postman (JSON):** Se actualizaron los payloads de las peticiones POST y PUT para enviar el campo `destino`[cite: 70].

### Script SQL utilizado:
```sql
ALTER TABLE vuelos ADD COLUMN destino VARCHAR(100);