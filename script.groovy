#!/usr/bin/env groovy

def testImage() {
    sh "mvn package"
}

return this