pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Checkout code from Git
                git 'https://github.com/your-username/coffee-order-microservice.git'
                // Build Maven project
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy to server
                // Add deployment steps here
            }
        }
    }
}
