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
                    def ec2IntanceIP = 'ec2-user@18.133.186.136'
                    def dockerComposeCmd = 'docker-compose -f docker-compose.yaml up'
                    sshagent(['ec2-server-key']) {
                        sh "scp docker-compose.yaml ${ec2IntanceIP}:/home/ec2-user"
                        sh "ssh -o StrictHostKeyChecking=no ${ec2IntanceIP} ${dockerComposeCmd}"
                    }
                }
            }
        }
    }
}
