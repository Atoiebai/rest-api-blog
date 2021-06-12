FROM ubuntu
RUN apt-get update && \
   apt-get install -y openjdk-11-jre-headless
ADD target/wave-be.jar wave-be.jar
EXPOSE 8085
ENTRYPOINT ["java" , "-jar" , "wave-be.jar"]
