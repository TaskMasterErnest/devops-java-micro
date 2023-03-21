def testImage() {
    echo "testing the app ..."
    sh "mvn test" 
}   

def buildImage() {
    echo 'building the docker image ...'
    sh "docker build -t ernestklu/${IMAGE_NAME} ."
}

def deployImage() {
    echo "deploying build..."
    echo "This is the third webhook branch .."
}

return this