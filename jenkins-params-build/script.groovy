def testImage() {
    echo "testing the app ..."
    sh "mvn clean package" 
}   

def buildImage() {
    echo 'building the docker image ...'
    sh "docker build -t ernestklu/java-maven-app:${IMAGE_NAME} ."
}

def deployImage() {
    echo "deploying build..."
    echo "This is the latest webhook branch .."
}

return this