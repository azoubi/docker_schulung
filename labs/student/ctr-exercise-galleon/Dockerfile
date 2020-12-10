
FROM adoptopenjdk/openjdk11:jdk-11.0.3.7

ENV GALEON_VERSION 4.2.5.Final 
ENV WILDFLY_VERSION 19.0.0.Final

RUN apt-get update && apt-get install -y curl unzip
RUN curl -Ls https://github.com/wildfly/galleon/releases/download/$GALEON_VERSION/galleon-$GALEON_VERSION.zip -o /tmp/galeon.zip
RUN unzip /tmp/galeon.zip && mv /galleon-${GALEON_VERSION} /galleon
RUN /galleon/bin/galleon.sh install wildfly:current#${WILDFLY_VERSION} --dir=/tmp/download --verbose && \
    rm -rf /tmp/download

