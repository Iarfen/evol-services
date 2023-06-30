# Test de EVOL SERVICES
Este es el test de EVOL SERVICES, desarrollado en **Spring Boot**. Incluye el archivo **evol_services.sql** para cargar la base de datos.

## Configuración
Primero se debe configurar la base de datos, para ello se debe crear el siguiente usuario dentro de psql:
```
CREATE USER iarfen WITH PASSWORD 'evolServices';
```
A continuación se debe crear la base de datos evol_services dentro de PostgreSQL con el usuario iarfen. El comando es el siguiente:
```
CREATE DATABASE evol_services;
```
Luego, para cargar los datos, se utiliza el comando:
```
psql evol_services < evol_services.sql
```

## Iniciar
Para ejecutar la aplicación se debe utilizar el comando ./mvnw spring-boot:run.

## Swagger
Para iniciar Swagger se debe visitar la siguiente URL:
http://localhost:8081/swagger-ui/index.html
