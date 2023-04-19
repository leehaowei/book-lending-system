bootstrap-db:
	docker-compose up
down:
	docker-compose down --volumes
connect-db:
	docker exec -it postgres-library psql -U myuser -d mydb

.PHONY: bootstrap-db