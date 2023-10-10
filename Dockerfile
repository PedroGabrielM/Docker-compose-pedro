FROM maven:3.8.5-openjdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app