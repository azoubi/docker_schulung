FROM gedoplan-seminar/ctr-demo-jdk

COPY --chown=java:java ./target/classes/ /opt/java/app/classes
COPY --chown=java:java ./target/libs/ /opt/java/app/lib

ENTRYPOINT [ "java", "-cp", "/opt/java/app/classes:/opt/java/app/lib/*", "com.kumuluz.ee.EeApplication" ]
