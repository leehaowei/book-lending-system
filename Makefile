db-up:
	docker-compose up -d
db-down:
	docker-compose down --volumes
connect-db:
	docker exec -it postgres-library psql -U myuser -d mydb

.PHONY: db-up db-down connect-db