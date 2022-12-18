#Multi stage build

#Base Image and name stage as builder
FROM maven:3-openjdk-11 AS builder

#create app directory inside our container
WORKDIR /decagon/app/src

#Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /decagon/app.pom.xml clean package

### 2nd Stage ###
FROM openjdk:11

WORKDIR /decagon/lib/

COPY --from=builder /decagon/app/target/Docker-0.0.1-SNAPSHOT.jar ./dockerized.jar

#Expose to the inner docker communication network
EXPOSE 8080

#Run the java application
ENTRYPOINT [ "java", "-jar", "/decagon/lib/dockerized.jar" ]