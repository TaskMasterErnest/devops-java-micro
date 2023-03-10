def testImage() {
    echo "testing the app ..."
    sh 'mvn test'
}   

def buildImage(string imageName) {
    echo "building the docker image..."
    withCredentials([
        usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
}

return this