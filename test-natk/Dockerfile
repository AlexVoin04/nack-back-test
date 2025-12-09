FROM eclipse-temurin:23-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew :test-natk:clean :test-natk:bootJar

FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app

COPY --from=build /app/test-natk/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]