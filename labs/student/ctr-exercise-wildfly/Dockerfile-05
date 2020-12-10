
FROM gedoplan-seminar/ctr-exercise-galleon AS galleon

COPY provisioning.xml /tmp/provisioning.xml
RUN /galleon/bin/galleon.sh provision /tmp/provisioning.xml --dir=/tmp/wildfly

# - - -

FROM adoptopenjdk/openjdk11:jdk-11.0.3_7-alpine-slim

RUN adduser -h /opt/jboss -D jboss

COPY --from=galleon --chown=jboss:jboss /tmp/wildfly /opt/jboss/wildfly

USER jboss

ENTRYPOINT [ "/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0" ]

