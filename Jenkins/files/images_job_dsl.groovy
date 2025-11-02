folder('Whanos base images') {
    description('Build base images for the Jenkins instance')
}


freeStyleJob('Whanos base images/whanos-c') {
    disabled(false)
    wrappers {
        buildInDocker {
            dockerfile('Whanos-images/c', 'Dockerfile.base')
        }
    }
}

freeStyleJob('Whanos base images/whanos-java') {
    disabled(false)
    wrappers {
    buildInDocker {
            dockerfile('Whanos-images/java', 'Dockerfile.base')
        }
    }
}

freeStyleJob('Whanos base images/whanos-javascript') {
    disabled(false)
    wrappers {
        buildInDocker {
            dockerfile('Whanos-images/javascript', 'Dockerfile.base')
        }
    }
}

freeStyleJob('Whanos base images/whanos-python') {
    disabled(false)
    wrappers {
        buildInDocker {
            dockerfile('Whanos-images/python', 'Dockerfile.base')
        }
    }
}

freeStyleJob('Whanos base images/whanos-befunge') {
    disabled(false)
    wrappers {
        buildInDocker {
            dockerfile('Whanos-images/befunge', 'Dockerfile.base')
        }
    }
}


freeStyleJob('Whanos base images/Build all base images') {
    disabled(false)
        publishers {
        downstream([
            'Whanos base images/whanos-java',
            'Whanos base images/whanos-c',
            'Whanos base images/whanos-javascript',
            'Whanos base images/whanos-python',
            'Whanos base images/whanos-befunge'
        ], 'SUCCESS')
    }
}
