# Simple Makefile to orchestrate dev and prod stacks

COMPOSE_DEV = docker-compose -f docker-compose.dev.yml
COMPOSE_PROD = docker-compose -f docker-compose.yml

.PHONY: help dev dev-d dev-down dev-logs dev-rebuild db db-down prod prod-d prod-down prod-logs prod-rebuild swagger openapi openapi-dev clean

help:
	@echo "Targets:"
	@echo "  dev          - Run dev stack foreground (Dev UI at :8081/q/dev)"
	@echo "  dev-d        - Run dev stack detached"
	@echo "  dev-down     - Stop dev stack"
	@echo "  dev-logs     - Tail dev logs"
	@echo "  dev-rebuild  - Rebuild dev images and restart"
	@echo "  db           - Start only database (dev)"
	@echo "  db-down      - Stop database (dev)"
	@echo "  prod         - Run prod stack foreground"
	@echo "  prod-d       - Run prod stack detached"
	@echo "  prod-down    - Stop prod stack"
	@echo "  prod-logs    - Tail prod logs"
	@echo "  prod-rebuild - Rebuild prod images and restart"
	@echo "  swagger      - Start prod with Swagger UI enabled"
	@echo "  openapi      - Save OpenAPI spec from prod to openapi.json"
	@echo "  openapi-dev  - Save OpenAPI spec from dev to openapi.dev.json"
	@echo "  clean        - Stop both stacks and remove volumes"

# Dev targets
dev:
	$(COMPOSE_DEV) up

dev-d:
	$(COMPOSE_DEV) up -d

dev-down:
	$(COMPOSE_DEV) down

dev-logs:
	$(COMPOSE_DEV) logs -f

dev-rebuild:
	$(COMPOSE_DEV) up --build

# Database only (dev)
db:
	$(COMPOSE_DEV) up -d db

db-down:
	$(COMPOSE_DEV) stop db

# Prod targets
prod:
	$(COMPOSE_PROD) up

prod-d:
	$(COMPOSE_PROD) up -d

prod-down:
	$(COMPOSE_PROD) down

prod-logs:
	$(COMPOSE_PROD) logs -f

prod-rebuild:
	$(COMPOSE_PROD) up --build

# Enable Swagger UI in prod and start detached
swagger:
	$(COMPOSE_PROD) down
	QUARKUS_SWAGGER_UI_ALWAYS_INCLUDE=true $(COMPOSE_PROD) up -d

# Save OpenAPI documents
openapi:
	curl -s http://localhost:8080/q/openapi -o openapi.json

openapi-dev:
	curl -s http://localhost:8081/q/openapi -o openapi.dev.json

# Stop everything and remove volumes (both dev and prod)
clean:
	$(COMPOSE_DEV) down -v || true
	$(COMPOSE_PROD) down -v || true