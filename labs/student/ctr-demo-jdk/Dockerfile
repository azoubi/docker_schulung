FROM appropriate/curl as buildhelper

ENV CORRETTO_VERSION 11.0.3.7.1

RUN mkdir -p /opt/java && \
    cd /opt/java && \
    curl https://d3pxv6yz143wms.cloudfront.net/${CORRETTO_VERSION}/amazon-corretto-${CORRETTO_VERSION}-linux-x64.tar.gz | tar xzf - && \
    mv amazon-corretto-${CORRETTO_VERSION}-linux-x64 jdk


FROM frolvlad/alpine-glibc:alpine-3.9_glibc-2.28

RUN adduser -h /opt/java -D java

COPY --from=buildhelper /opt/java/jdk /opt/java/jdk

USER java

WORKDIR /opt/java

ENV JAVA_HOME /opt/java/jdk

ENV PATH="${JAVA_HOME}/bin:${PATH}"
