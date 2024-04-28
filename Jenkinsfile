pipeline {
    agent any

    environment {
        // Define the Maven home directory
        MAVEN_HOME = tool 'Maven'
        PATH = "$PATH:$MAVEN_HOME/bin"
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
    }
}
