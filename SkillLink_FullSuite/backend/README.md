# SkillLink API (Backend)
Java 17 + Spring Boot 3.3.4 • H2 • Swagger • Seeds • Docker • Testes

## Rodar
```bash
mvn clean install
mvn spring-boot:run
```
- API: http://localhost:8080
- Swagger: http://localhost:8080/swagger-ui/index.html
- H2: http://localhost:8080/h2-console  (jdbc:h2:mem:upskillingdb | sa / "")

## CRUDs
- /api/usuarios
- /api/trilhas
- /api/competencias
- /api/matriculas
