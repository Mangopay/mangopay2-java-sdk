#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.
# NOTE: Travis-CI can only publish SNAPSHOT versions. To release a version, you need
#       to use the internal ReadyTalk Jenkins job.

if [ "$TRAVIS_REPO_SLUG" == "Mangopay/mangopay2-java-sdk" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "release" ]; then

  echo -e "Starting publish to Sonatype...\n"

  ./gradlew uploadArchives -PnexusUsername="${SONATYPE_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}" -Psigning.keyId=93605ADB -Psigning.password="${SIGNING_PASSWORD}" -Psigning.secretKeyRingFile=.utility/signingkey.gpg
  RETVAL=$?

  if [ $RETVAL -eq 0 ]; then
    echo 'Completed publish!'
    ./gradlew --stacktrace  closeAndPromoteRepository
  else
    echo 'Publish failed.'
  fi

fi