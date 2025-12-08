# 📦 Test NATK — Проверка GitHub Container Registry

Этот репозиторий содержит два тестовых проекта:

- test-natk-lib — простая Java-библиотека
- test-natk — Spring Boot API, использующее библиотеку

> Проекты нужны для проверки публикации Docker-образов в GitHub Container Registry (GHCR).

Структура репозитория:

```bash
root/
│  settings.gradle
│  build.gradle
|  Dockerfile
│
├── test-natk-lib/
│     build.gradle
│     src/
│
└── test-natk/
      build.gradle
      src/
```

## 📚 1. Работа с многомодульным проектом

Так как проект является многомодульным, зависимости настраиваются через Gradle:
В `test-natk/build.gradle`:

```shell
implementation project(":test-natk-lib")
```

Эта команда пересоберёт проект и обновит зависимости, включая локально опубликованную `test-natk-lib`.

## 🛠 2. Сборка проекта

Выполняется из корневой директории:

```shell
./gradlew clean build
```

## 🚀 3. Запуск Spring Boot API

Из корня:

```shell
./gradlew :test-natk:bootRun
```

По умолчанию приложение стартует на порту из `application.properties` (обычно 8080).

Проверка:

```shell
http://localhost:8080/hello?name=Natk
```

## 🐳 4. GitHub Container Registry

Этот репозиторий используется для тестирования:

- сборки Docker-образа Spring Boot приложения test-natk
- публикации в GHCR
