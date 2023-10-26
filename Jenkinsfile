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
                    def branchName = sh(script: 'git rev-parse --abbrev-ref HEAD', returnStatus: true).trim()

                    // Set the SonarQube properties
                    def sonarProperties = [
                        "-Dsonar.projectKey=my-project-${branchName}", // Use a dynamic project key with the branch name
                        "-Dsonar.sources=src",
                        "-Dsonar.login=admin",
                        "-Dsonar.password=admin123"
                        // Add other properties as needed
                    ]

                    sh "mvn clean install sonar:sonar ${sonarProperties.join(' ')}"
                }
            }
        }
    }
}
