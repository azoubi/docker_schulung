#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-demo-rest

docker build -t $NAMESPACE/$REPOSITORY $@ .