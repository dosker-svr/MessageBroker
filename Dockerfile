FROM openjdk:11
EXPOSE 8080
ADD target/MessageBroker-0.0.1-SNAPSHOT.jar message_broker.jar
ENTRYPOINT ["java", "-jar", "message_broker.jar"]