#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-demo-rest

docker run --rm --name $REPOSITORY -d -p 8080:8080 $NAMESPACE/$REPOSITORY
