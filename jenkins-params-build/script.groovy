def testImage() {
    echo "testing the app ..."
    sh "mvn clean package" 
}   

def buildImage() {
    echo 'building the docker image ...'
    sh "docker build -t ernestklu/java-maven-app:1.7.0 ."
}

def deployImage() {
    echo "deploying build..."
    echo "This is the finest webhook branch .."
}

return this