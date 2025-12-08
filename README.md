# 📦 Test NATK — Проверка GitHub Container Registry

Этот репозиторий содержит два тестовых проекта:

- test-natk-lib — простая Java-библиотека
- test-natk — Spring Boot API, использующее библиотеку

> Проекты нужны для проверки публикации Docker-образов в GitHub Container Registry (GHCR).

## 🚀 1. Сборка тестовой библиотеки (test-natk-lib)

Перейдите в папку test-natk-lib и выполните:

```shell
./gradlew publishToMavenLocal
```

Это соберёт библиотеку и установит её в `~/.m2/repository`, чтобы проект `test-natk` мог её использовать.

## 🛠 2. Сборка Spring Boot API (test-natk)

Перейдите в папку test-natk и выполните:

```shell
./gradlew clean build --refresh-dependencies
```

Эта команда пересоберёт проект и обновит зависимости, включая локально опубликованную `test-natk-lib`.

## ☕ Требование: JDK

Все команды должны выполняться под одинаковым JDK >=17 (Например, 23).

Проверить текущую версию можно так:

```shell
java -version
```

Если используется не JDK, который больше 16, установите временно переменные окружения (PowerShell):

```shell
$env:JAVA_HOME="C:\Users\Ivanov-AS.NATK\Desktop\jdk-23.0.1_windows-x64_bin\jdk-23.0.1"
$env:PATH="$env:JAVA_HOME\bin;$env:PATH"
java -version
```

Где: `C:\Users\Ivanov-AS.NATK\Desktop\jdk-23.0.1_windows-x64_bin\jdk-23.0.1` - путь к установленному JDK.
