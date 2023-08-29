FROM openjdk:11-jdk-slim
WORKDIR /casestudyApp
COPY target/BoutiqueApp-0.0.1-SNAPSHOT.jar boutiqueapp.jar
EXPOSE 8089
CMD ["java", "-jar", "bookingApp.jar"]
