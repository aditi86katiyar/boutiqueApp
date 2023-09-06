FROM openjdk:17-jdk-slim
WORKDIR /casestudyApp
COPY target/boutiqueapp-0.0.1-SNAPSHOT.jar boutiqueapp.jar
EXPOSE 9020
CMD ["java", "-jar", "boutiqueapp.jar"]
