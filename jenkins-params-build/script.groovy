def testImage() {
    echo "testing the app ..."
    sh "mvn package" 
}   

def buildImage() {
    echo 'building the docker image ...'
    sh "docker build -t ernestklu/java-maven-app:${IMAGE_NAME} ."
}

def deployImage() {
    echo "deploying build..."
    echo "This is the finest webhook branch .."
}

return this