def testImage() {
    echo "testing the app ..."
    sh 'mvn test'
}   

def deployImage() {
    echo "deploying build..."
}

return this