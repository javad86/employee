pipeline {
    agent any

    environment {
        IMAGE_NAME = 'javad86/employee'
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {
        stage('Build JAR') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build \
                      -t ${IMAGE_NAME}:${IMAGE_TAG} \
                      -t ${IMAGE_NAME}:latest .
                """
            }
        }
    }

    post {
        success {
            echo "Docker image built successfully: ${IMAGE_NAME}:${IMAGE_TAG}"
        }

        failure {
            echo 'Build failed.'
        }
    }
}