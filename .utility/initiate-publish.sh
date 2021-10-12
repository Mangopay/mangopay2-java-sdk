#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.
# NOTE: Travis-CI can only publish SNAPSHOT versions. To release a version, you need
#       to use the internal ReadyTalk Jenkins job.

echo -e "Starting publish to Sonatype...\n"

./gradlew publish -PnexusUsername="${MAVEN_USERNAME}" -PnexusPassword="${MAVEN_PASSWORD}" -Psigning.keyId=610AABD3 -Psigning.password="${SIGNING_PASSWORD}" -Psigning.secretKeyRingFile=.gnupg/secring.gpg
#RETVAL=$?

#if [ $RETVAL -eq 0 ]; then
#  echo 'Completed publish!'
#  ./gradlew closeAndReleaseRepository -PnexusUsername="${MAVEN_USERNAME}" -PnexusPassword="${MAVEN_PASSWORD}"
#else
#  echo 'Publish failed.'
#fi
