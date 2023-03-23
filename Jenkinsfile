#!/usr/bin/env groovy

@Library('jenkins-shared-library')

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment {
        DOCKER_IMAGE = 'ernestklu/java-maven-app'
    }
    stages {
        stage('increment application version') {
            steps {
                script {
                    echo "incrementing application version ..."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def pom = new XmlSlurper().parseText(readFile('pom.xml'))
                    def version = pom.version.text()
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('packaging application ...') {
            steps {
                script {
                    gv.testImage()
                }
            }
        }
        stage('build and push to Docker ...') {
            steps {
                script {
                    dockerBuildImage "${DOCKER_IMAGE}:${IMAGE_NAME}"
                    dockerLogin()
                    dockerPush "${DOCKER_IMAGE}:${IMAGE_NAME}"
                }
            }
        }
        stage('commit to repo') {
            steps {
                script {
                    withCredentials([gitUsernamePassword(credentialsId: '6f310649-fa84-4ad2-a050-38354b76596a', gitToolName: 'Default')]) {
                    
                    sh 'git config user.email "jenkins@example.com"'
                    sh 'git config user.name "jenkins"'

                    sh 'git add .'
                    sh 'git commit -m "ci: version bump"'
                    sh 'git push origin HEAD:jenkins-ci'

                    }
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    def dockerComposeCmd = 'docker-compose -f docker-compose.yaml up'
					def instanceIp = "ec2-user@18.170.50.124"
					sshagent(['ec2-server-key']) {
						sh "scp docker-compose.yaml ${instanceIp}:/home/ec2-user"
						sh "ssh -o StrictHostKeyChecking=no ${instanceIp}:/home/ec2-user ${dockerComposeCmd}"
                    }
                }
            }
        }
    }
}