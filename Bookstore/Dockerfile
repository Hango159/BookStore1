FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /home/app
# Copiem pom.xml separat pentru a profita de cache-ul Docker
COPY pom.xml .
RUN mvn dependency:go-offline
# Copiem sursele și compilăm
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
# Folosim wildcard-ul pentru a găsi JAR-ul indiferent de locația din build
COPY --from=build /home/app/target/bookstore-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

