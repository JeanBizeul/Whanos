folder('Projects') {
    description('Checks projets status and deploys them if necessary')
}


job('link-project') {
    disabled(false)
    description('Links a project repository to Jenkins')

    parameters {
        stringParam('PROJECT_NAME', null , 'Used to identify created job')
        stringParam('GIT_REPOSITORY_URL', null , 'Application repository')
        stringParam('GIT_BRANCH', 'main', 'Branch to build')
        credentialsParam('SSH_CREDENTIALS') {
            type('com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey')
            required(true)
            defaultValue('')
            description('SSH credentials for accessing the repository' )
        }
    }
        triggers {}
    steps {
        dsl {
            text("""
                job("Projects/\${PROJECT_NAME}") {
                    disabled(false)

                    scm {
                        git {
                            remote {
                                url("\${GIT_REPOSITORY_URL}")
                                credentials("\${SSH_CREDENTIALS}")
                            }
                            branch("\${GIT_BRANCH}")
                        }
                    }
                    wrappers {
                        preBuildCleanup()
                    }
                    triggers{
                        scm('* * * * *')
                    }
                    steps {
                    }
                }
        """)
        }
    }
}
