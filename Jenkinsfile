pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nikpalyi/coffee-order-service.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}