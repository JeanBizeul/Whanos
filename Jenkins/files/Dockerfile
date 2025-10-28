FROM jenkins/jenkins:lts-jdk21

USER root

WORKDIR /var/jenkins_home/

RUN apt-get update && \
    apt-get install -y git make gcc g++ pip npm maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p /var/jenkins_home/casc_configs

COPY configuration.yaml /var/jenkins_home/casc_configs/

USER jenkins

ENV CASC_JENKINS_CONFIG="/var/jenkins_home/casc_configs"

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"