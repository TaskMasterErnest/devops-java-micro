def testImage() {
    echo "testing the app ..."
    sh "mvn test" 
}   

def deployImage() {
    echo "deploying build..."
    echo "This is another webhook branch .."
}

return this