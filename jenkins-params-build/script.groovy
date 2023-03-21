def testImage() {
    echo "testing the app ..."
    sh "mvn test" 
}   

def deployImage() {
    echo "deploying build..."
    echo "This is the webhook branch ..."
}

return this