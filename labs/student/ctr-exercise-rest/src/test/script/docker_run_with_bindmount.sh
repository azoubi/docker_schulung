#!/bin/sh

# Change bind mount folder to your setting
FOLDER_ON_HOST="/tmp/ctr-exercise-rest-h2"
#FOLDER_ON_HOST="/c/seminar/ctr-exercise-rest-h2"

if [ ! -d $FOLDER_ON_HOST ]
then
  echo "Please change script variable FOLDER_ON_HOST first" >&2
  exit 1
fi

NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-exercise-rest

docker run --name ctr-exercise-rest \
  --rm \
  -p 8080:8080 \
  --env DATASOURCE=exerciseH2 \
  -d \
  -v $FOLDER_ON_HOST:/opt/jboss/seminar \
  $NAMESPACE/$REPOSITORY