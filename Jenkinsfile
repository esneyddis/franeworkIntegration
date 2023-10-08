pipeline {
    agent any

    stages {
        stage('Master building') {
            steps {
                echo 'Deploy to stage'
            }
        }
        stage('Testing build') {
            steps {
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'git@github.com:esneyddis/franeworkIntegration.git']])
            }
        }
        stage('Deploy to stage') {
            steps {
                echo 'Deploy to stage'
            }
        }
    }
}
