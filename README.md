# Instana monitoring for Java on Fargate using Jib to build images

## Setup

Export the `DOWNLOAD_KEY` and `VERSION` environment variables and run the script below:

```sh
curl -L --user _:${DOWNLOAD_KEY} -o instana/fargate-collector-jvm.jar https://artifact-public.instana.io/artifactory/shared/com/instana/fargate-collector-jvm/${VERSION}/fargate-collector-jvm-${VERSION}.jar
```

The right value for `DOWNLOAD_KEY` is the one you use to download other Instana artefacts (you may also know it as "sales key" or "agent key").

The right value for `VERSION` you know by browing the `https://artifact-public.instana.io/artifactory/shared/com/instana/fargate-collector-jvm/` repository (sorry, not yet automated to our liking :P), using `_` and the `DOWNLOAD_KEY` as username and password, respectively.

## Build

Export the `DOCKERHUB_USERNAME` and `DOCKERHUB_PASSWORD` environment variables, setting as values valid Docker Hub credentials to fetch the base `openjdk:11.0.8-slim-buster` image:

```sh
./mvnw compile jib:dockerBuild -Djib.from.auth.username=${DOCKERHUB_USERNAME} -Djib.from.auth.password=${DOCKERHUB_PASSWORD}
```
