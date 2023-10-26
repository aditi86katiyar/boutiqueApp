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
                sh 'mvn clean install'  // Replace with your build commands mvn clean install sonar:sonar
            }
        }

	 stage('Build') {
            steps {
                // Build your project (e.g., compile code, run tests)
                sh 'mvn clean install sonar:sonar'  // Replace with your build commands 
            }
        }

       }

 }
