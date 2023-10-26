pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from your version control system
                checkout scm
            }
        }

        stage('Build and SonarQube Scan') {
            steps {
                script {

                    // Set the SonarQube properties
                    def sonarProperties = [
                        "-Dsonar.sources=src",
                        "-Dsonar.login=admin",
                        "-Dsonar.password=admin123"
                        // Add otchecking pull requesther properties as needed
                    ]

                    sh "mvn clean install sonar:sonar ${sonarProperties.join(' ')}"
                }
            }
        }
    }
}
