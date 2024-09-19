# Usar una imagen base de OpenJDK 22
FROM openjdk:22-jdk-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo pom.xml y los archivos de código fuente al contenedor
COPY pom.xml .
COPY src ./src

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Construir el proyecto usando Maven
RUN mvn clean package -DskipTests

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación desde el archivo JAR en la carpeta target
CMD ["java", "-jar", "target/fairfinance-pocketpartners-backend-0.0.1-SNAPSHOT.jar"]
