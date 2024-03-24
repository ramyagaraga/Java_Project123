pipeline {
    agent none
    stages {
        stage ('Cloning git code') {
            steps {
                git url: 'https://github.com/SreekakulapuBharatkumar/Java_Project.git'
                    branch: 'master'
            }
        }
        stage ('Build the image') {
            steps {
                sh '''
                    docker image build -t javaproject .
                    docker image ls
                '''

            }
        }
    }
}