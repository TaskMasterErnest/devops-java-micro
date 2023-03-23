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
        stage('deploy') {
            steps {
                script {
                    echo "SSH-ing into the EC2 instance"
                    def dockerCmd = "docker run -p 3080:8000 -d ernestklu/falcon-look-app:latest"
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@18.133.186.136 ${dockerCmd}"
                    }
                }
            }
        }
    }
}
