#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-exercise-rest

docker run --rm --name $REPOSITORY -d -p 8080:8080 $NAMESPACE/$REPOSITORY
