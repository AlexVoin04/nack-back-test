FROM eclipse-temurin:23-jdk-alpine AS build
WORKDIR /app
COPY ../../ ./
RUN ./gradlew :test-natk-admin:clean :test-natk-admin:bootJar

FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app
COPY --from=build /app/test-natk-admin/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]