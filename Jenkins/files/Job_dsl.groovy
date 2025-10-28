folder('Whanos base images') {
    description('Build base images for the Jenkins instance')
}
folder('Projects') {
    description('Checks projets status and deploys them if necessary')
}


freeStyleJob('Whanos base images/whanos-c') {
    disabled(false)
}


freeStyleJob('Whanos base images/whanos-java') {
    disabled(false)
}

freeStyleJob('Whanos base images/whanos-javascript') {
    disabled(false)
}

freeStyleJob('Whanos base images/whanos-python') {
    disabled(false)
}

freeStyleJob('Whanos base images/whanos-befunge') {
    disabled(false)
}


freeStyleJob('Whanos base images/Build all base images') {
    disabled(false)
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
