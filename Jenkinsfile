pipeline {
    agent none
    stages {
        stage ('Cloning git code') {
            agent { label 'DOCKER' }
            steps {
                git url: 'https://github.com/SreekakulapuBharatkumar/Java_Project.git',
                    branch: 'master'
            }
        }
        stage ('Build the image') {
            agent { label 'DOCKER' }
            steps {
                sh '''
                    docker image build -t javaproject .
                    docker image ls
                '''

            }
        }
    }
}