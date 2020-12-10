#!/bin/sh
NAMESPACE=gedoplan-seminar
REPOSITORY=ctr-demo-hello

docker build -t $NAMESPACE/$REPOSITORY $@ .