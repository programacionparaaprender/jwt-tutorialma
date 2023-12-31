FROM openjdk:11
VOLUME /tmp
ENV IMG_PATH=/img
EXPOSE 8080
RUN mkdir -p /img
ADD ./target/jwt-tutorialma*.jar jwt-tutorialma-v1.jar
ENTRYPOINT ["java", "-jar", "jwt-tutorialma-v1.jar"]

#FROM rickw/ubuntu12-java8
#COPY target/jwt-tutorialma*.jar /app/jwt-tutorialma-v1.jar
#WORKDIR /app
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "jwt-tutorialma-v1.jar"]