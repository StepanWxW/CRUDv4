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