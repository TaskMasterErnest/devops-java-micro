pipeline {
    agent any
    tools {
        mnv 'Maven'
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
                sh 'mvn package'
            }
        }
        stage ("deploy") {
            steps {
                echo "deploying the application ..."
            }
        }
    }
}
