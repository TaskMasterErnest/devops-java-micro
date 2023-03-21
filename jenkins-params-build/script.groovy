def testImage() {
    echo "testing the app ..."
    sh "mvn test" 
}   

def deployImage() {
    echo "deploying build..."
    echo "This is the third webhook branch .."
}

return this