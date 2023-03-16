#!/user/bin/env groovy
@Library('jenkins-shared-library')

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