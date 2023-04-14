FROM alpine
RUN apk update
RUN apk fetch openjdk11
RUN apk add openjdk11
COPY target/getNotas-0.0.1-SNAPSHOT.war getNotas-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","getNotas-0.0.1-SNAPSHOT.war"]