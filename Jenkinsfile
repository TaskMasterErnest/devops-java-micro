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
            }
        }
        stage ("deploy") {
            steps {
                echo "deploying the application ..."
            }
        }
    }
}
