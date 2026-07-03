# Sistema de Mesa de Ayuda (Help Desk) - Arquitectura de Microservicios

Proyecto académico TECSUP - Arquitectura basada en microservicios con Spring Boot,
Spring Cloud (Eureka, Config Server, Gateway), Resilience4j y Docker.

## Módulos
- **config-server**: Configuración centralizada
- **eureka-server**: Descubrimiento de servicios
- **api-gateway**: Puerta de entrada única (/api/**)
- **ms-usuarios**: Registro, login, gestión de responsables (agentes)
- **ms-tickets**: Crear tickets, actualizar estados, asignar responsables
- **ms-historial**: Historial de atención por ticket

## Cómo levantar el proyecto
Ver `docker-compose.yml` (pendiente de implementar).

## Estado del desarrollo
- [ ] config-server
- [ ] eureka-server
- [ ] api-gateway
- [ ] ms-usuarios
- [ ] ms-tickets
- [ ] ms-historial
- [ ] Resilience4j
- [ ] Actuator
- [ ] Dockerfiles
- [ ] docker-compose
- [ ] Scripts SQL
- [ ] Colección Postman