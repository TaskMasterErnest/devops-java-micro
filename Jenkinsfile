#!/usr/bin/env groovy
@Library('jenkins-shared-library')
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
		stage('build docker image') {
			steps {
				script {
					dockerImageBuild 'ernestklu/java-maven-app:v3.3.0'
				}
			}
		}
		stage('Login to Docker') {
			steps {
				script {
					dockerLogin()
				}
			}
		}
		stage('Push Image') {
			steps {
				script {
					dockerPush 'ernestklu/java-maven-app:v3.3.0'
				}
			}
		}
	}
}