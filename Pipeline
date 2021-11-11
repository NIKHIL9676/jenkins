pipeline {
          agent any 
          tools {
          //maven is tool as M2_HOME
          maven "M2_HOME"
          }
        stages{
        stage ('checkout'){ 
        steps {
        //clone the repositry from git 
        git 'https://github.com/NIKHIL9676/jenkins.git'
        }
        }
        stage ('build'){
        steps {
        //run maven build on unix agent
        sh "mvn -Dmaven.test.failure.ignore=true clean package"
         }
         }
        stage ('nexusuploader'){
        steps {
         nexusArtifactUploader(
                nexusVersion: 'nexus3',
                protocol: 'http',
                nexusUrl: '20.115.116.229:8081',
                groupId: 'com.example',
                version: '0.0.1-SNAPSHOT',
                repository: 'maven-snapshots',
                credentialsId: '5bfde82f-74d3-4fd9-9195-5dbc40edef86',
                artifacts: 
                [
                [
                artifactId: 'helloworld2',
                classifier: '',
                file: 'target/helloworld2-0.0.1-SNAPSHOT.jar',
                type: 'jar']
                ])
        }
        }
        stage ('Deploy'){
        steps{sh 'pwd'
                sh 'ls -lrt'
                sshPublisher(
                continueOnError: false, 
                failOnError: true,
                publishers: [
                sshPublisherDesc(
                configName: "deployserver",
                transfers: [sshTransfer(sourceFiles: 'target/helloworld2-0.0.1-SNAPSHOT.jar')],
                verbose: true
        )
        ]
        )
        }
        }
        }
        }
        
