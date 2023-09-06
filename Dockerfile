FROM openjdk:11-jdk-slim
WORKDIR /casestudyApp
COPY target/boutiqueapp-0.0.1-SNAPSHOT.jar boutiqueapp.jar
EXPOSE 8089
CMD ["java", "-jar", "boutiqueapp.jar"]
