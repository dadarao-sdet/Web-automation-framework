
pipeline {
    agent {
        label 'windows-chrome'
    }

    parameters {
        string(
            name: 'TEST_CASE',
            defaultValue: 'ALL',
            description: 'Enter ALL or Cucumber tag expression, e.g. @TC01 or @TC02'
        )
    }

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
                script {
                    def selectedTags = params.TEST_CASE.trim()

                    if (!selectedTags || selectedTags == 'ALL') {
                        bat 'mvn -B clean test'
                    } else {
                        if (!(selectedTags ==~ /[A-Za-z0-9_@()!&| -]+/)) {
                            error 'Invalid Cucumber tag expression'
                        }

                        bat "mvn -B clean test \"-Dcucumber.filter.tags=${selectedTags}\""
                    }
                }
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
