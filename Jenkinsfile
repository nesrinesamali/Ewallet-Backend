pipeline {
    agent any
    stages {
        stage('Checkout SCM') {
            steps {
                git url: 'https://github.com/nesrinesamali/Ewallet-Backend.git', branch: 'main'
            }
        }
        stage('Hello') {
            steps {
                echo 'Pipeline fonctionne !'
            }
        }
    }
}

