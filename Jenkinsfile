pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('test') {
            steps {
                echo "testing the app ..."
                sh "mvn test"
            }
        }
        stage('build & push to Docker') {
            steps {
                echo "building the docker image..."
                withCredentials([
                    usernamePassword(credentialsId: 'docker-creds', 
                    passwordVariable: 'PASS', usernameVariable: 'USER')]) 
                    {
                    sh 'docker build -t ernestklu/java-maven-app:v3 .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push ernestklu/java-maven-app:v3"
                }
            }
        }
        stage('deploy') {
            steps {
                echo "deploying the application..."
            }
        }
    }
}