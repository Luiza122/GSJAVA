
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

1. Clone o repositório:
```
git clone <(https://github.com/Luiza122/GSJAVA.git)>
```

2. Abra no IntelliJ ou VS Code com plugin Java.

3. Suba o projeto:
```
mvn spring-boot:run
```

4. O servidor iniciará em:
```
http://localhost:8080
```

---

## 6. Endpoints Principais

### Usuários
- `GET /usuarios`
- `GET /usuarios/{id}`
- `POST /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### Trilhas
- `GET /trilhas`
- `GET /trilhas/{id}`
- `POST /trilhas`
- `PUT /trilhas/{id}`
- `DELETE /trilhas/{id}`

### Competências
- `GET /competencias`
- `GET /competencias/{id}`
- `POST /competencias`
- `PUT /competencias/{id}`
- `DELETE /competencias/{id}`

### Matrículas
- `GET /matriculas`
- `GET /matriculas/{id}`
- `POST /matriculas`
- `PUT /matriculas/{id}`
- `DELETE /matriculas/{id}`

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
