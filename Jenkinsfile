#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
                
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
                    gv.buildImage 'ernestklu/java-maven-app:v3.0.2'
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
