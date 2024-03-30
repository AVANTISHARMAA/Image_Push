pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage ('Build Maven'){
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/AVANTISHARMAA/image_push']])
                sh 'mvn clean install'
            }
        }
        stage ('Build docket image'){
            steps {
                script {
                    sh '/usr/local/bin/docker build -t avanti .'   # ALways put a . in the end to build an image.
                   }
                }
            }
        }
    }
    