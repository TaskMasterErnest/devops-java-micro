#!/usr/bin/env groovy

def buildJar() {
    echo "building the jar application ..."
}

def dockerImage() {
    sh "docker build -t ernestklu/java-maven-app:v3.0.0"
}

return this