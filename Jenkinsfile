pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                 git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/saiku219/sai-official-bank.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build and tests successful!'
        }
        failure {
            echo 'Build failed. Check logs.'
        }
    }
}
