FROM maven:3.8-openjdk-8-slim AS build

WORKDIR /app

COPY spring-utils/pom.xml spring-utils/
RUN mvn -f spring-utils/pom.xml dependency:resolve
COPY spring-utils/src spring-utils/src
RUN mvn -f spring-utils/pom.xml install

COPY base/pom.xml base/
RUN mvn -f base/pom.xml dependency:resolve
COPY base/sequence.txt base/
COPY base/sequence2.txt base/
COPY base/src base/src
RUN mvn -f base/pom.xml install

COPY webapp/pom.xml webapp/
RUN mvn -f webapp/pom.xml dependency:resolve

COPY pom.xml .
RUN mvn dependency:resolve

COPY webapp/src webapp/src
RUN mvn -f webapp/pom.xml install

COPY lib lib

RUN mvn package

FROM openjdk:8-jdk-alpine

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait

WORKDIR /app

COPY --from=build /app/webapp/target/dependency/jetty-runner.jar jetty-runner.jar
COPY --from=build /app/webapp/target/SafeSeed.war SafeSeed.war

ENTRYPOINT /wait && java -jar jetty-runner.jar --path /sispotr --port 9090 SafeSeed.war