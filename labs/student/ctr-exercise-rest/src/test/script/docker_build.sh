#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-exercise-rest

docker build -t $NAMESPACE/$REPOSITORY $@ .