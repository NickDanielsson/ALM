FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

#WORKDIR /Javafolder

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]


# docker build -t run-test-image .

# docker run --name run-test-container run-test-image

#FROM adoptopenjdk/openjdk11:alpine-jre
#EXPOSE 8080
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT [“java”, “-jar”, “app.jar”]
