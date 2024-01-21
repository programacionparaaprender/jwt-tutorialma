

FROM openjdk:11
VOLUME /tmp
ENV IMG_PATH=/img
EXPOSE 8762
RUN mkdir -p /img
ADD ./target/jwt-tutorialma-1*.jar jwt-tutorialma-1.jar
ENTRYPOINT ["java", "-jar", "jwt-tutorialma-1.jar"]

#FROM rickw/ubuntu12-java8
#COPY target/jwt-tutorialma*.jar /app/jwt-tutorialma-v1.jar
#WORKDIR /app
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "jwt-tutorialma-v1.jar"]

#FROM openjdk:17-jdk-alpine
#COPY target/springapirest-swagger-1.0.1-SNAPSHOT.jar java-app.jar
#ENTRYPOINT ["java", "-jar", "java-app.jar"]
