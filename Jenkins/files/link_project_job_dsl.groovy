folder('Projects') {
    description('Checks projets status and deploys them if necessary')
}


freeStyleJob('link-project') {
    disabled(false)
    parameters {
        stringParam('GIT_REPOSITORY_URL', null , 'Application repository')
    }
        triggers {}
    steps {
        dsl {
            text("""
                freeStyleJob("/Projects") {
                    disabled(false)
                    scm {
                        github("\$GITHUB_NAME")
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
