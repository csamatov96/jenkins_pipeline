node {
    stage("Pull Repo")
    properties([parameters([string(defaultValue: '3.15.153.106', description: '''Dev: 3.15.153.106
                                                                                QA: 3.15.44.42 
                                PROD: 18.191.19.171''', name: 'Remote_instances', trim: true)])])
    git 'git@github.com:farrukh90/jenkins_april.git'
    
    stage("Install Apache"){
        sh "ssh  ec2-user@${Remote_instances}     sudo yum install httpd -y"
    
    stage("Create Index.html"){
        sh "scp index.html ec2-user@${Remote_instances}:/tmp"
    }
    stage("Move files"){
        sh "ssh ec2-user@${Remote_instances}    sudo mv /tmp/index.html     var/www/html/index.html"
    }
    stage("Restart httpd") {
        sh "ssh ec2-user@${Remote_intances} sudo systemctl restart httpd"
    }


    }
}