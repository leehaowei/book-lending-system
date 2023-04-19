bootstrap-db:
	docker-compose up
down:
	docker-compose down --volumes
connect-db:
	docker exec -it book-lending-system_db_1 psql -U myuser -d mydb

.PHONY: bootstrap-db