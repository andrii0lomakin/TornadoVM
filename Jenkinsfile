pipeline {
    agent any
    options {
        timestamps()
        timeout(time: 1, unit: 'HOURS')
	}
	environment {
		 JAVA_HOME="/opt/jenkins/jdk1.8.0_131"
		 GRAAL_ROOT="/opt/jenkins"
		 TORNADO_ROOT="/var/lib/jenkins/workspace/Tornado"
		 TORNADO_REVISION='$(echo `git rev-parse --short HEAD`)'
		 GRAAL_VERSION="0.22"
		 JVMCI_VERSION="1.8.0_131"
		 PATH="/var/lib/jenkins/workspace/Tornado-pipeline/bin/bin:$PATH"    
		 TORNADO_SDK="/var/lib/jenkins/workspace/Tornado-pipeline/bin/sdk"
		 CMAKE_ROOT="/opt/jenkins/cmake-3.10.2-Linux-x86_64"
	}

	stages {
		stage('checkout-branch') {
			steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '9bca499b-bd08-4fb2-9762-12105b44890e', url: 'https://github.com/beehive-lab/tornado.git']]])
			}
		}
		stage('build') {
			steps {
				sh 'make'
			}
		}
	
	}
	post {
        success {
            slackSend color: '#00CC00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
        }
        failure {
            slackSend color: '#CC0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
        }
    }
}
