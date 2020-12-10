#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-demo-jdk

docker build -t $NAMESPACE/$REPOSITORY $@ .