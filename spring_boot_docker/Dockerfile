FROM openjdk:11
ARG PATH=build/libs/*.jar
COPY ${PATH} app.jar
EXPOSE 8080 8087
ENTRYPOINT ["java","-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8087","app.jar"]