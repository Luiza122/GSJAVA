# Skill Link - Sistema de Gestão de Trilhas, Competências e Matrículas

---

## 1. Descrição do Projeto

O Skill Link é um sistema para gerenciar trilhas de aprendizagem corporativas, permitindo:

- Cadastro, listagem, atualização e exclusão de **Usuários**
- Gestão de **Trilhas de Aprendizagem**
- Associação de trilhas com **Competências**
- Registro e manutenção de **Matrículas** de usuários em trilhas
- Validações e tratamento global de erros

O projeto segue boas práticas de arquitetura limpa, separação de responsabilidades e uso de camadas independentes.

---

## 2. Arquitetura de Pastas (Conforme Requisitos da Disciplina)

```
src/
 └── main/java/com/example/skill_link
      ├── model/          # Entidades JPA
      ├── repository/     # Interfaces que estendem JpaRepository
      ├── service/        # Regras de negócio
      ├── controller/     # Endpoints REST
      └── exception/      # Tratamento de erros personalizados
```

Não foram usados DTOs, conforme instrução obrigatória do professor.

---

## 3. Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- H2 / MySQL (dependendo da configuração)
- JUnit 5
- Mockito
- Maven

---

## 4. Configuração do Banco de Dados

O banco foi estruturado com as seguintes tabelas:

- usuarios
- trilhas
- competencias
- matriculas
- trilha_competencia (tabela de relação ManyToMany)

Exemplos de inserts iniciais estão no arquivo SQL fornecido.

---

## 5. Como Rodar o Projeto

**O que você precisa:**
- Java JDK 21
- Maven

**Passos:**
```bash
git clone https://github.com/Luiza122/GSJAVA.git
cd GSJAVA/skill-link
mvn spring-boot:run
```

Pronto! A aplicação roda em `http://localhost:8080`

**Compilar e testar:**
```bash
mvn clean package
mvn test
```

> Se der erro de compilador, é porque o JDK não está configurado. Ver seção de Troubleshooting.

---

## 6. Endpoints Principais

### Usuários
- `GET http://localhost:8080/api/usuarios`
- `GET http://localhost:8080/api/usuarios/{id}`
- `POST http://localhost:8080/api/usuarios`
- `PUT http://localhost:8080/api/usuarios/{id}`
- `DELETE http://localhost:8080/api/usuarios/{id}`

### Trilhas
- `GET http://localhost:8080/api/trilhas`
- `GET http://localhost:8080/api/trilhas/{id}`
- `POST http://localhost:8080/api/trilhas`
- `PUT http://localhost:8080/api/trilhas/{id}`
- `DELETE http://localhost:8080/api/trilhas/{id}`

### Competências
- `GET http://localhost:8080/api/competencias`
- `GET http://localhost:8080/api/competencias/{id}`
- `POST http://localhost:8080/api/competencias`
- `PUT http://localhost:8080/api/competencias/{id}`
- `DELETE http://localhost:8080/api/competencias/{id}`

### Matrículas
- `GET http://localhost:8080/api/matriculas`
- `GET http://localhost:8080/api/matriculas/{id}`
- `POST http://localhost:8080/api/matriculas`
- `PUT http://localhost:8080/api/matriculas/{id}`
- `DELETE http://localhost:8080/api/matriculas/{id}`

---

## 7. Exemplos de JSON (Importante — Sem DTO)

### Criar Trilha
```json
{
  "nome": "Trilha Backend Java",
  "descricao": "Estrutura completa de backend",
  "nivel": "AVANCADO",
  "cargaHoraria": 120,
  "focoPrincipal": "Java",
  "competencias": [
    { "id": 1 },
    { "id": 2 }
  ]
}
```

### Criar Matrícula (Formato Obrigatório)
```json
{
  "usuario": { "id": 1 },
  "trilha": { "id": 2 },
  "dataInscricao": "2025-10-16",
  "status": "ATIVA"
}
```

## 8. Exemplos com cURL

**Listar usuários**
```bash
curl http://localhost:8080/api/usuarios
```

**Buscar usuário**
```bash
curl http://localhost:8080/api/usuarios/1
```

**Criar usuário**
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{"nome":"João","email":"joao@example.com","senha":"123"}'
```

**Listar trilhas, competências ou matrículas**
```bash
curl http://localhost:8080/api/trilhas
curl http://localhost:8080/api/competencias
curl http://localhost:8080/api/matriculas
```

## 9. Banco de Dados

Os scripts de inicialização estão em:
- `src/main/resources/db/schema.sql` (tabelas)
- `src/main/resources/db/data.sql` (dados de exemplo)

Por padrão usa H2 (em memória), mas pode configurar MySQL em `application.properties`.

## 10. Testes

```bash
mvn test
```

Os testes usam JUnit 5 e Mockito, testam listagem, busca, criação, atualização e deleção.

## 12. Integrantes

- **Fernanda Rocha Menon** - RM554673
- **Giulia Rocha Barbizan Alves** - RM558084
- **Luiza Macena Dantas** - RM556237

