FROM openjdk:11
EXPOSE 8080
ADD target/kubernetes-test.jar kubernetes-test.jar
ENTRYPOINT ["java","-jar","/kubernetes-test.jar"]