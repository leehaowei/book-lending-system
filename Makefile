bootstrap-db:
	docker-compose up -d
down:
	docker-compose down --volumes
connect-db:
	docker exec -it postgres-library psql -U myuser -d mydb

.PHONY: bootstrap-db