FROM openjdk:11
EXPOSE 1010
ADD target/spring-security-jwt.jar spring-security-jwt.jar
ENTRYPOINT ["java","-jar","/spring-security-jwt.jar"]