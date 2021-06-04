FROM openjdk:8
ADD target/wave-be.jar wave-be.jar
EXPOSE 8085
ENTRYPOINT ["java" , "-jar" , "wave-be.jar"]
g
