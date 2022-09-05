# Задание
Практика:
Необходимо реализовать консольное CRUD приложение, которое
взаимодействует с БД и позволяет выполнять все CRUD операции над
сущностями:
Writer (id, firstName, lastName, List<Post> posts, Region region)
Post (id, content, created, updated, PostStatus)
Region (id, name)
PostStatus(enum ACTIVE, DELETED)
Требования:
- Все CRUD операции для каждой из сущностей
- Придерживаться подхода MVC
- Для сборки проекта использовать Maven
- Для взаимодействия с БД - Hibernate
- Для конфигурирования Hibernate - аннотации
- Инициализация БД должна быть реализована с помощью flyway
  Технологии: Java, PostgeSQL, Hibernate, Flyway, Maven

### Настройка Flyway
1. Скачать flyway https://flywaydb.org/
2. Рапаковать flyway. Зайти в папку \flyway-9.2.2\conf. В файле flyway:
* В строке " flyway.url= " url к вашей базе postgresSQL
* В строке " flyway.user= " указать юзера
* В строке " flyway.password= " указать пароль
* Везде убрать значок " # "
3. В папке с проектом flyway-9.2.2\sql загрузить файл из папки resources "V1__create_tables.sql"
4. В командной строке перейти в папку с проектом flyway-9.2.2\
Ввести команду flyway migrate
