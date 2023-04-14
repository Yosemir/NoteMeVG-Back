FROM alpine

RUN apk update

RUN apk fetch openjdk11

RUN apk add openjdk11

COPY target/notemevg-0.0.1-SNAPSHOT.war notemevg-0.0.1-SNAPSHOT.war

ENTRYPOINT ["java","-jar","notemevg-0.0.1-SNAPSHOT.war"]