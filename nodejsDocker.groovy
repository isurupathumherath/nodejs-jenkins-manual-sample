job('NodeJS Groovy Project') {
    scm {
        git('git://github.com/isurupathumherath/devops-sample.git') {
            node ->
                node / gitConfigName('isurupathumherath')
                node / gitConfigEmail('isurupathumherath@gmail.com')
        }
    }

    triggers {
        scm('H/5 * * * *')
    }

    wrappers {
        nodejs('nodejs')
    }

    steps{
        dockerBuildAndPublish {
            repositoryName('isuruherath22923/docker-example')
            tag('${GIT_REVISION, length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            createFingerprint(false)
            skipDecorate()
        }
    }
}