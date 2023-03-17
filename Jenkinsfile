#!/usr/bin/env groovy
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
		stage('testing') {
			steps {
				script {
					gv.buildJar()
                    testJar()
				}
			}
		}
        stage('build') {
            steps {
                script {
                    buildImage 'ernestklu/java-maven-app:v4.1.1'
                }
            }
        }
		stage('push') {
			steps {
				script {
					dockerPush 'ernestklu/java-maven-app:v4.1.1'
				}
			}
		}
    }
}