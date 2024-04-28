pipeline {
    agent any

    tools {
        // Specify the Maven tool by name
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

        stage('SonarQube Analysis') {
            steps {
                script {
                    def mvnHome = tool 'Maven3'
                    withSonarQubeEnv('SonarQube') {
                        sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=coffee-order-microservice -Dsonar.projectName='coffee-order-microservice'"
                    }
                }
            }
        }

        stage('Maven Build') {
            steps {
                // Run Maven commands within the 'withMaven' block
                withMaven(maven: 'Maven3', configFileProvider([configFile(fileId: 'your-maven-settings-id', targetLocation: 'settings.xml')])) {
                    sh 'mvn clean verify'
                }
            }
        }
    }
}
