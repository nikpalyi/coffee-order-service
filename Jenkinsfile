pipeline {
    agent any

    tools {
        // Specify the Maven tool by its installation name
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nikpalyi/coffee-order-service.git'
            }
        }

        stage('Build') {
            steps {
                // Use 'mvn' command directly since Maven should be available in the PATH
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

        stage('Maven Build') {
            steps {
                // Run Maven commands within the 'withMaven' block
                withMaven(maven: 'Maven3') {
                    sh 'mvn clean verify'
                }
            }
        }
    }
}