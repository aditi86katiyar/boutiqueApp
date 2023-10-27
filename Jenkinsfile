pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and SonarQube Scan') {
            steps {
                script {
                    // Get the branch name dynamically
                    def branchName = sh(script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()

                    // Get the PR name/number (change ID)
                    def prNumber = env.CHANGE_ID

                    echo "Branch Name: ${branchName}"
                    echo "PR Number: ${prNumber}"

                    // Set the SonarQube properties
                    def sonarProperties = [
                        "-Dsonar.projectKey=${branchName}", // Use the branch name as the project key
                        "-Dsonar.sources=src",
                        "-Dsonar.login=admin",
                        "-Dsonar.password=admin123", // Replace with your GitHub token
                        // Add other properties as needed
                    ]

                    sh "mvn clean install sonar:sonar ${sonarProperties.join(' ')}"
                }
            }
        }
    }
}
