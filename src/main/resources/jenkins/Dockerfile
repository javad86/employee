FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y docker.io git maven && \
    apt-get clean