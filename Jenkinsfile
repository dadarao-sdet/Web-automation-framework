
pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'apache-maven-3.9.16'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/cucumber-report.html',
                             allowEmptyArchive: true
        }
    }
}
