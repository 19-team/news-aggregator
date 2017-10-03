# Hack News Aggregator
###### See demo - [https://hack-news-aggregator.herokuapp.com](https://hack-news-aggregator.herokuapp.com) 
---
## Огляд
Hack News Aggregator - агрегатор новин, який використовує популярні українські інтернет канали новин (RSS) для того, щоб ви завжди залишались в курсі подій. 

## Технології


- Spring Framework
- ROME (rometools.github.io/rome/)
- Spring Data JPA
- Hibernate 
- PostgreSQL
- Maven 
- Lombok
- Bootstrap 

## Локальний запуск 
Збірка 

    mvn clean package   
    
Запуск 

    java -jar target/dependency/webapp-runner.jar --expand-war target/*.war  
    
Доступ:

    http://localhost:8080  
    
## Ліцензія
 Ліцензія MIT.
