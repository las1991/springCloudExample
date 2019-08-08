FROM store/oracle/serverjre:8
VOLUME /tmp
ADD consul-client-discovery-1.0-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]