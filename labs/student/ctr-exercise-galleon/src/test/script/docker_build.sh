#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-exercise-galleon

docker build -t $NAMESPACE/$REPOSITORY $@ .