pipeline {
    agent any
    tools {
        maven 'Maven'
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
