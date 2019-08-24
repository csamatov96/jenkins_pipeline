node {
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: '3.15.153.106', description: '''Dev:3.15.153.106 QA:3.15.44.42 Prod:18.191.19.171''', name: 'Remote_instance', trim: false)])])
        git 'https://github.com/leventelibal/jenkins_repo.git'
    }
    stage("Install Apache"){
        sh "ssh   centos@${Remote_instance}    sudo yum install httpd -y"
    }
    stage("Create Index.html"){
        sh "scp  index.html  centos@${Remote_instance}:/tmp"
    }
    stage("Move Files"){
        sh "ssh   centos@${Remote_instance}    sudo mv /tmp/index.html  /var/www/html/index.html"
    }
    stage("Restart httpd"){
        sh "ssh   centos@${Remote_instance} sudo systemctl restart  httpd"
    }
}