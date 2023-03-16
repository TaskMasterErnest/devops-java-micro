#!/user/bin/env groovy

library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
		[$class: 'GitSCMSource',
		remote: 'https://github.com/TaskMasterErnest/jenkins-shared-library.git',
		credentialsId: 'github-creds']
)

def gv

pipeline {
    agent any 
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('test Library') {
            steps {
                script {
                    testCode()
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
    }
}