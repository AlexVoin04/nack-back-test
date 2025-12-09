# 📦 Test NATK — Проверка GitHub Container Registry

Этот репозиторий содержит **три модуля Gradle**:

- `test-natk-lib` — простая Java-библиотека
- `test-natk` — Spring Boot API, использующее библиотеку
- `test-natk-admin` — второй Spring Boot сервис

> Проекты нужны для проверки публикации Docker-образов в GitHub Container Registry (GHCR).

Структура репозитория:

```bash
root/
│  settings.gradle
│  build.gradle
│  Dockerfile
│
├── test-natk-lib/
├── test-natk/ ← Dockerfile + GHCR workflow
└── test-natk-admin/ ← Dockerfile + GHCR workflow
```

---

## 📚 1. Работа с многомодульным проектом

Так как проект является многомодульным, зависимости настраиваются через Gradle:
В `test-natk/build.gradle`:

```shell
implementation project(":test-natk-lib")
```

---

## 🚀 2. Запуск Spring Boot API test-natk

Из корня:

```shell
./gradlew :test-natk:bootRun
```

По умолчанию приложение стартует на порту из `application.properties` (обычно 8080).

Проверка:

```shell
http://localhost:8080/hello?name=Natk
```

---

## 🚀 3. Запуск Spring Boot API test-natk-admin:

Из корня:

```shell
./gradlew :test-natk-admin:bootRun
```

Проверка:

```shell
http://localhost:8082/admin/status
```

---

## 🐳 4. GitHub Container Registry

Этот репозиторий используется для тестирования:

- сборки Docker-образа Spring Boot приложения test-natk
- публикации в GHCR

---

## 🚀 5. GitHub Container Registry

Для каждого сервиса есть отдельный workflow:

- .github/workflows/docker-test-natk.yml

- .github/workflows/docker-test-natk-admin.yml

При пуше в master образы автоматически публикуются в GHCR.

```
ghcr.io/<owner>/test-natk
ghcr.io/<owner>/test-natk-admin
```