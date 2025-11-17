
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

- Java 17
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

- **Pré-requisitos:**
- `Java JDK 21` instalado e `JAVA_HOME` configurado (obrigatório para usar o Maven).
- `Maven` (normalmente o wrapper `mvnw` já resolve se preferir).

**Clonar e rodar (rápido):**
1. Clone o repositório:
```
git clone https://github.com/Luiza122/GSJAVA.git
cd GSJAVA/skill-link
```
2. Rodar com o wrapper ou seu Maven local:
```
./mvnw spring-boot:run    # ou
mvn spring-boot:run
```
3. O servidor inicia em:
```
http://localhost:8080
```

**Build e testes:**
```
mvn clean package
mvn test
```

**Observações:**
- Se houver erro "No compiler is provided" instale/configure o JDK e reinicie o terminal (veja Troubleshooting abaixo).

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

## 8. Exemplos rápidos (cURL)

- **Listar usuários**
```
curl -X GET "http://localhost:8080/api/usuarios" -H "Accept: application/json"
```

- **Buscar usuário por id**
```
curl -X GET "http://localhost:8080/api/usuarios/1" -H "Accept: application/json"
```

- **Criar usuário** (exemplo JSON — ajuste campos conforme sua entidade `Usuario`):
```
curl -X POST "http://localhost:8080/api/usuarios" \
  -H "Content-Type: application/json" \
  -d '{"nome":"João Silva","email":"joao@example.com","senha":"senha123"}'
```

- **Listar trilhas**
```
curl -X GET "http://localhost:8080/api/trilhas"
```

- **Criar trilha**
```
curl -X POST "http://localhost:8080/api/trilhas" \
  -H "Content-Type: application/json" \
  -d '{"nome":"Trilha Backend Java","descricao":"...","nivel":"INTERMEDIARIO","cargaHoraria":40,"focoPrincipal":"Java","competencias":[{"id":1}]}'
```

- **Listar competências**
```
curl -X GET "http://localhost:8080/api/competencias"
```

- **Listar matrículas**
```
curl -X GET "http://localhost:8080/api/matriculas"
```

## 9. Banco de Dados e scripts de inicialização
- Os scripts de schema e dados iniciais estão em `src/main/resources/db/schema.sql` e `src/main/resources/db/data.sql`.
- Por padrão o projeto pode usar H2 em memória ou MySQL dependendo da configuração em `src/main/resources/application.properties`.
- Para usar MySQL, ajuste as propriedades de conexão (`spring.datasource.*`) e remova/ajuste a configuração de inicialização automática, se necessário.

## 10. Testes unitários
- Rodar todos os testes:
```
mvn test
```
- Os testes usam JUnit 5 e Mockito, com mocks dos repositórios. Arquivos de teste estão em `src/test/java`.

## 11. Troubleshooting (problemas comuns)
- Erro: `No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?`
  - Solução rápida (PowerShell, temporário):
  ```powershell
  Set-Item -Path Env:JAVA_HOME -Value 'C:\Program Files\Java\jdk-21'
  $env:PATH = $env:JAVA_HOME + '\bin;' + $env:PATH
  mvn -v
  ```
  - Para persistir, configure `JAVA_HOME` nas Variáveis de Ambiente do Windows (Painel de Controle → Sistema → Configurações avançadas → Variáveis de ambiente).

- Erro 404 nos endpoints: verifique se a aplicação realmente iniciou em `http://localhost:8080` e se o prefixo `/api` está sendo aplicado pelos controllers (ex.: `@RequestMapping("/api/usuarios")`).

## 12. Contribuição
- Sinta-se livre para abrir issues ou pull requests. Mantenha commits pequenos e com mensagens claras.

## 13. Contato
- Autor/Manutenção: `Luiza122` (repositório GitHub)

## Integrantes
- **Fernanda Rocha Menon** - RM554673
- **Giulia Rocha Barbizan Alves** - RM558084
- **Luiza Macena Dantas** - RM556237


---

## 8. Testes Unitários

Os testes foram implementados com:
- JUnit 5
- Mockito
- Mock dos repositórios
- Testes de:
  - listagem
  - busca com exceção
  - criação
  - atualização
  - deleção

Estão localizados na pasta indicada pelo professor:  
```
/src/test/java/testes
```

---

## 9. Tratamento de Erros

O sistema possui:

- `NaoEncontradoException`
- `GlobalExceptionHandler`

Erros retornam mensagens claras para o cliente, como:
```
Usuário de id - 5 não encontrado
```
