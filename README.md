# Laboratorio N-Capas: API de Especímenes de Hyrule 🗡️🛡️

Este repositorio contiene la implementación de una API REST bajo la arquitectura N-Capas (Controller, Service, Repository, Entity) construida con Spring Boot, incluyendo estandarización de respuestas, paginación y manejo global de excepciones.

## ⚙️ Configuración Importante (Base de Datos)

Antes de ejecutar el proyecto, es **estrictamente necesario** configurar las credenciales de conexión a la base de datos local.

1. Navega al archivo `src/main/resources/application.yml` (o `.properties`).
2. Reemplaza los valores de `username` y `password` con tus credenciales locales:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/hyrule_db
       username: TU_USUARIO
       password: TU_PASSWORD
