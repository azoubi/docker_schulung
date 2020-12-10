#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-exercise-wildfly

docker build -t $NAMESPACE/$REPOSITORY $@ .