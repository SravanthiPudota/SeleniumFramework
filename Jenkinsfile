pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                echo 'Code already available via Jenkinsfile pipeline'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deployment to QA completed'
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'TestNG Report'
            ])
        }
    }
}