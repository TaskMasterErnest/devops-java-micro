pipeline {
    agent any
    tools {
        maven 'Maven-3.8'
    }
    stages {
        stage ("test") {
            steps {
                echo "testing the application ..."
                sh 'maven test'
            }
        }
        stage ("build") {
            steps {
                echo "building the application ..."
                sh 'maven package'
            }
        }
        stage ("deploy") {
            steps {
                echo "deploying the application ..."
            }
        }
    }
}
