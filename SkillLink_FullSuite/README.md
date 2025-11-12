# SkillLink – Suite Completa (v1.0)
- **Backend**: Spring Boot 3 + H2 + Swagger + Seeds + Docker + Testes
- **Frontend**: Protótipo React (estático) — pode ser aberto direto no navegador
- **Docs**: Conceito consolidado
- **Insomnia**: gerei uma collection se desejar (posso incluir numa próxima revisão)

## Rodar Backend
```
cd backend
mvn clean install
mvn spring-boot:run
```
Swagger: http://localhost:8080/swagger-ui/index.html  
H2: http://localhost:8080/h2-console  (jdbc:h2:mem:upskillingdb | user: sa | senha: vazia)
