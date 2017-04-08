FROM openjdk:8-jdk

COPY hello-world.yml /data/finance-record-service/hello-world.yml
COPY /target/finance-record-service-0.0.1-SNAPSHOT.jar /data/finance-record-service/finance-record-service-0.0.1-SNAPSHOT.jar

WORKDIR /data/finance-record-service

RUN java -version

CMD ["java","-jar","finance-record-service-0.0.1-SNAPSHOT.jar","server","hello-world.yml"]

EXPOSE 8080-8081