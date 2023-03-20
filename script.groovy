#!/usr/bin/env groovy

def testImage() {
    sh "mvn test"
}

return this