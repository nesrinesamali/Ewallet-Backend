pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Récupère le code depuis GitHub
                git url: 'https://github.com/nesrinesamali/Ewallet-Backend.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Compile avec Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Lance les tests
                sh 'mvn test'
            }
        }
    }
}
