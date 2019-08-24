node {
    stage("Say Hello")
    properties([parameters([text(defaultValue: 'Chyngyz', description: 'give me ur name ', name: 'NAME')]), pipelineTriggers([cron('* * * * *')])])
    sh "echo Hello ${NAME}"
}