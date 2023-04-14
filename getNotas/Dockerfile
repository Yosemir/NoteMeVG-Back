FROM adoptopenjdk:17-jre-hotspot-alpine
RUN apk update && apk add --no-cache curl
ARG APP_FILE=target/getNotas-0.0.1-SNAPSHOT.war
ARG APP_HOME=/app/
ENV APP_HOME ${APP_HOME}
EXPOSE 8080
COPY ${APP_FILE} ${APP_HOME}/app.war
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar ${APP_HOME}/app.war" ]
