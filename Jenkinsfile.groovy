node {
    stage("Say Hello")
    properties([parameters([string(defaultValue: '3.15.153.106', description: '''Dev: 3.15.153.106
                                                                                QA: 3.15.44.42 
                                PROD: 18.191.19.171''', name: 'Remote_instances', trim: true)])])
    git 'https://github.com/csamatov96/jenkins_pipeline.git'
}