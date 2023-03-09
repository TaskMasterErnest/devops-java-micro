def groovy
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage ('init') {
            steps {
                gv = load "script.groovy"
            }
        }
        stage('test') {
            steps {
                script {
                    gv.testImage()
                }
            }
        }
        stage('build & push to Docker') {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage('deploy') {
            steps {
                echo "deploying the application..."
            }
        }
    }
}
