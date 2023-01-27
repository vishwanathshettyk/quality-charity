# create/pull image using :  docker build -t quality-charity:latest .
# run the container :  docker run -it --name quality-charity-container quality-charity:latest /bin/bash
# now you can run test using run :  mvn clean test (runs only on chrome now)


#
# Build stage
#
FROM --platform=linux/amd64 markhobson/maven-chrome:jdk-8
WORKDIR /Quality-Charity
COPY src /Quality-Charity/src
COPY pom.xml /Quality-Charity
RUN mvn -f /Quality-Charity/pom.xml clean install -Dmaven.test.skip=true
