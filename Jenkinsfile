pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                url: 'https://github.com/javad86/employee.git'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
    }

    post {
        success {
            echo 'Employee project built successfully.'
        }

        failure {
            echo 'Employee project build failed.'
        }
    }
}