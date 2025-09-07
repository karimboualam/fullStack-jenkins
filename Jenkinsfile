pipeline {
    agent any

    tools {
        maven "Maven_3.9"   
        nodejs "Node_22"    
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/karimboualam/fullStack-jenkins.git'
            }
        }

        stage('Build Backend - Spring Boot') {
            steps {
                dir('jenkins') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Frontend - Angular') {
            steps {
                dir('jenkins-angular') {
                    bat 'npm install'
                    bat 'npm run build -- --configuration production'
                }
            }
        }
    }

    post {
        success {
            echo "✅ Build Fullstack réussi !"
        }
        failure {
            echo "❌ Build échoué, voir logs."
        }
    }
}
