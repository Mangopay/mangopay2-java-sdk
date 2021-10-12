#!/bin/bash
# This script initiates the Gradle publishing task when pushes to master occur.
# NOTE: Travis-CI can only publish SNAPSHOT versions. To release a version, you need
#       to use the internal ReadyTalk Jenkins job.

echo -e "Starting publish to Sonatype...\n"

./gradlew publish -PnexusUsername="${MAVEN_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}" -Psigning.keyId=AF02E028 -Psigning.password="${SIGNING_PASSWORD}" -Psigning.secretKeyRingFile=/home/runner/.gnupg/pubring.kbx
RETVAL=$?

if [ $RETVAL -eq 0 ]; then
  echo 'Completed publish!'
  ./gradlew closeAndReleaseRepository -PnexusUsername="${SONATYPE_USERNAME}" -PnexusPassword="${SONATYPE_PASSWORD}"
else
  echo 'Publish failed.'
fi
