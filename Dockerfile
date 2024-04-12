FROM maven:3.8.3-openjdk-17 AS Build
RUN git clone https://github.com/ramyagaraga/Java_Project123.git
WORKDIR Java_Project
RUN mvn clean install

FROM openjdk:17-alpine
LABEL author="Ramya"
WORKDIR /tmp/
COPY --from=Build Java_Project/target/demo1-0.0.1-SNAPSHOT.jar /tmp/demo1-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","demo1-0.0.1-SNAPSHOT.jar"]
