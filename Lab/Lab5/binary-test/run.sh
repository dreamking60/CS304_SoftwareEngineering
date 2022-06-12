#!/bin/bash

echo "building"

javac -cp "/home/czh/Junit5/*" `find src -name *.java` -d bin

echo "running"

java -javaagent:/home/czh/CS304/Lab/package/jacoco/lib/jacocoagent.jar -jar /home/czh/Junit5/junit-platform-console-standalone-1.8.2.jar -cp bin --select-class CalculatorTest

java -jar /home/czh/CS304/Lab/package/jacoco/lib/jacococli.jar report --classfiles ./bin ./jacoco.exec --html ./html --name CalculatorReport
