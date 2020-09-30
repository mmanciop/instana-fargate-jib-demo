# Instana monitoring for Java on Fargate using Jib to build images

## Setup

Create a new `server` in your Maven `settings.xml` for `artifact-public.instana.io`:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">

  <servers>
    ...
    <server>
      <id>artifact-public.instana.io</id>
      <username>_</username>
      <password>DOWNLOAD_KEY</password>
    </server>
    ...
  </servers>

</settings>
```

Be sure to replace `DOWNLOAD_KEY` in the snippet above.
The right value for `DOWNLOAD_KEY` is the one you use to download other Instana artefacts (you may also know it as "sales key" or "agent key").

## Build

Export the `DOCKERHUB_USERNAME` and `DOCKERHUB_PASSWORD` environment variables, setting as values valid Docker Hub credentials to fetch the base `openjdk:11.0.8-slim-buster` image:

```sh
./mvnw versions:use-latest-versions@update-instana-fargate-collector
./mvnw jib:dockerBuild -Djib.from.auth.username=${DOCKERHUB_USERNAME} -Djib.from.auth.password=${DOCKERHUB_PASSWORD}
```

The first Maven build, running `versions:use-latest-versions@update-instana-fargate-collector`, will update the local `pom.xml` with the latest version of the `com.instana:fargate-collector-jvm`.
The second Maven build will actually create your image.
