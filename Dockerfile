FROM --platform=linux/amd64 openjdk:8-alpine
#WORKDIR /app
#COPY . .
#RUN ./mvnw clean package
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/remittances-be.jar"]
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/mediappbackend-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]