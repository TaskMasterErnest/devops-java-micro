#!/usr/bin/env groovy
@Library('jenkins-shared-library') 
def call(body) {
def config = [:]
body.resolveStrategy = Closure.DELEGATE_FIRST
body.delegate = config
body()

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
				}
			}
		}
    }
}