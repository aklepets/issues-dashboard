pipeline {
    agent any

    stages {
//         stage('Build') {
//             steps {
//                 // Clean and build the project
//                 sh './mvnw clean package -DskipTests'
//             }
//         }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image and tag it as "myapp:latest"
                    docker.build("myapp:latest")
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    // Run the Docker container in detached mode
                    docker.image("myapp:latest").run("-p 8000:8000 --name myapp-container")
                }
            }
        }
    }

    post {
        always {
            // Clean up the Docker container after the job
            script {
                sh 'docker stop myapp-container || true'
                sh 'docker rm myapp-container || true'
            }
        }
    }
}