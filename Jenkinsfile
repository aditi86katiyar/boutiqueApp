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
                // Build your project and run SonarQube analysis
                sh 'mvn clean install sonar:sonar'  // Replace with your build and analysis commands
            }
        }
    }

    
}
