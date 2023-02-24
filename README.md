# FinalCase_PatikaSpringBoot
Kredi Başvuru Sistemi
## Proje Konusu
Bir kredi başvuru sistemi için, kredi başvuru isteklerini alıp ilgili kriterlere göre müşteriye kredi sonucunu dönen servisin
içinde yer alacak restful bir uygulamanın Spring Boot framework kullanılarak yazılması ve isteğe bağlı olarak önyüzünün yazılması.
-Kimlik numarası, ad-soyad, aylık gelir, telefon bilgileri, doğum tarihi ve teminat(opsiyonel) 
kimlik numarasıyla daha önceden yazıldığı varsayılan kredi skoru servisine gidilir ve ilgili kişiye ait kredi 
skoru alınarak aşağıdaki kurallara göre kullanıcıya kredi sonucu gösterilir. (Onay veya Red olarak iki seçenek olabilir.) 
-Kredi skoru "application.properties" dosyasında
```sh
#credit config
credit.limit.factor=4
```
olarak belirlenmiştir.

## Local'de çalıştırmak için
lokalde çalıştırmak için:
spring.datasource.url=jdbc:mariadb://localhost:3309/app

## Swagger UI
Swagger ui için tarayıcıdan:
http://localhost:8080/swagger-ui/#

## Docker
Docker için,
```sh
mvn install -DskipTests
docker-compose build
docker-compose up -d
```

