FROM java:8-jre-alpine
VOLUME /tmp
VOLUME /home/hblog/
ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
RUN echo $(date) > /image_built_at
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
