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
		stage('test & build') {
			steps {
				script {
					gv.buildJar()
                    testJar()
                    buildImage 'ernestklu/java-maven-app:4.0.0'
				}
			}
		}
    }
}