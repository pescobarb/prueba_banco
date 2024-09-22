# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Crear un directorio para la aplicación
VOLUME /tmp

# Establecer el puerto en el que correrá la aplicación
EXPOSE 8080

# Copiar el archivo JAR generado a la imagen Docker
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]

