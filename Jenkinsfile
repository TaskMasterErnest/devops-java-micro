#!/usr/bin/env groovy
@Library('jenkins-shared-library') 
def gv
pipeline {
	agent any
	stages {
		stage('init') {
			steps {
				gv = load "script.groovy"
			}
		}
		stage('test & build') {
			steps {
				script {
					gv.buildJar()
                    gv.buildJar()
				}
			}
		}
    }
}