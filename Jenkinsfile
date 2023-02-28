pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage ("test") {
            steps {
                echo "testing the application ..."
                sh 'mvn test'
            }
        }
        stage ("build") {
            steps {
                echo "building the application ..."
                sh "docker build -t ernestklu/java-maven-app:v2 ."
                withCredentials([
                    usernamePassword(credentials: docker-creds, usernameVariable: 'USER', passwordVariable: 'PASS' )]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push ernestklu/java-maven-app:v2"
                    }
            }
        }
        stage ("deploy") {
            steps {
                echo "deploying the application ..."
            }
        }
    }
}
