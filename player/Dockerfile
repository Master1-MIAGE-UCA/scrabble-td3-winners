FROM openjdk:17-jdk-slim
ARG JAR_FILE=/target/player-1.jar
COPY ${JAR_FILE} player.jar
ENTRYPOINT java -jar /player.jar $SERVER_IP