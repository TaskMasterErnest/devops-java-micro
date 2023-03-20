#!/usr/bin/env groovy

def testImage() {
    sh "mvn clean package"
}

return this