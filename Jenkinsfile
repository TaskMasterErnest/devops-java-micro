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
                    gv.dockerImage()
                }
            }
        }
    }
}