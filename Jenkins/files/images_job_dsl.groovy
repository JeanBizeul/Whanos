folder('Whanos base images') {
    description('Build base images for the Jenkins instance')
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
        publishers {
        downstream(
            'whanos-java',
            'whanos-c',
            'whanos-javascript',
            'whanos-python',
            'whanos-befunge',
            'FAILURE'
        )
    }
}
