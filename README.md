# SISMATO Hackágua — Back-end
O SismaTO é uma plataforma centralizada e integrada, projetada para consolidar, analisar e disseminar dados e informações estratégicas sobre o saneamento básico e a qualidade da água no estado do Tocantins. O sistema visa aprimorar a gestão e a transparência dos serviços de abastecimento de água e esgotamento sanitário em toda a tocantinense.
[FRONT END](https://github.com/Matheus-Nardi/sismato-app)

<span>
  <img src="https://img.shields.io/badge/Quarkus-4695EB?style=for-the-badge&logo=quarkus&logoColor=white" alt="Quarkus">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/PostGIS-3E6E93?style=for-the-badge" alt="PostGIS">
  <img src="https://img.shields.io/badge/pgAdmin-0083B3?style=for-the-badge" alt="pgAdmin">
</span>

API e serviços de back-end do SISMATO, construídos com Quarkus e orquestrados via Docker Compose. Inclui banco de dados PostgreSQL (PostGIS) e pgAdmin para administração.

## Tecnologias e versões
- Quarkus `3.28.4` 
- Java `21`
- Maven Surefire/Failsafe `3.5.4`
- Docker e Docker Compose
- PostgreSQL/PostGIS: `postgis/postgis:latest`
- pgAdmin: `dpage/pgadmin4:latest`
Veja `pom.xml` e `docker-compose.dev.yml` para detalhes completos.

## Estrutura do DB

[Diagrama do Banco de Dados - Visão Geral](https://drive.google.com/drive/folders/1HPP7n4gRl92ffoZcgtCdg4tkfnRVgddx?usp=sharing)
Recomendando o download da imagem para melhor visualização!

## Pré-requisitos
- Linux ou Windows com WSL2 habilitado
- Docker Desktop (com integração WSL habilitada) ou Docker em Linux
- Docker Compose
- GNU Make (`make`)
- Opcional: Java 21 e Maven (para builds locais fora do Docker)

## Como executar (dev)
1. Após a clonagem do repositorio abra um terminal e navegue até o diretório do back-end:
   ```bash
   cd sismato-hackagua
   ```
2. Restaure o banco de desenvolvimento (usa Docker e um dump em `src/main/resources/sismato.dump`):
   ```bash
   make db-restore-dev
   ```
3. Suba o ambiente de desenvolvimento:
   ```bash
   make dev
   ```
4. Endpoints e serviços:
   - API Quarkus: `http://localhost:8080`
   - PostgreSQL (dev): `localhost:5432` (user: `root`, senha: `root`, db: `sismato`)
   - pgAdmin (dev): `http://localhost:7001` (login: `root@root.com` / `root`)

## Alvos úteis do Makefile
- `make dev-d`: sobe stack dev em background
- `make dev-logs`: segue logs do stack dev
- `make dev-down`: derruba stack dev
- `make db-dump-dev`: gera dump do banco dev em `src/main/resources/`
- `make prod`: stack de produção (foreground)
- `make prod-d`: stack de produção (background)
- `make prod-down`: derruba stack de produção
- `make clean`: para tudo e remove volumes

## Observações
- O `docker-compose.dev.yml` mapeia `8080:8080` para a API, `5432:5432` para Postgres e `7001:80` para o pgAdmin.
- Se usar Windows, execute os comandos dentro de um terminal WSL (Ubuntu, Debian, etc.).
- Garanta que o Docker Desktop esteja com a integração WSL habilitada e o engine rodando.
