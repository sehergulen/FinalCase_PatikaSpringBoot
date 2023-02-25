# FinalCase_PatikaSpringBoot
Credit Approval System



```sh
#credit config
credit.limit.factor=4
```

## Local'de çalıştırmak için
Local:
spring.datasource.url=jdbc:mariadb://localhost:3309/app

## Swagger UI
Swagger ui:
http://localhost:8080/swagger-ui/#

## Docker

```sh
mvn install -DskipTests
docker-compose build
docker-compose up -d
```

