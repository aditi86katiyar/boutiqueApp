pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from your version control system
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build your project (e.g., compile code, run tests)
                sh 'mvn clean install'  // Replace with your build commands
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // Set the SonarQube scanner configuration
                    def scannerHome = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    withSonarQubeEnv('YourSonarQubeServer') {
                        // Use 'YourSonarQubeServer' as the SonarQube server configuration name defined in Jenkins

                        // Run the SonarQube scanner
                        sh "${scannerHome}/bin/sonar-scanner"  // Adjust the path if needed
                    }
                }
            }
        }
    }

 }
