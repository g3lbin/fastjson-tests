#!/bin/bash

PATH_JACOCO_CLI_JAR="/home/cristiano/github-projects/fastjson-tests/src/test/lib/jacococli.jar"
PATH_FJSON_SRC="/home/cristiano/Scrivania/ISW2_class/2022/EsempiJacocoFastJSON/fastjson/src"
PATH_FJSON_JAR="/home/cristiano/Scrivania/ISW2_class/2022/EsempiJacocoFastJSON/fastjson-1.2.79.jar"
PATH_FJSON_FAT_JAR="/home/cristiano/Scrivania/ISW2_class/2022/EsempiJacocoFastJSON/fat-jar/fastjson-1.2.79-fat.jar"

## CREAZIONE CON JACOCO DA CLI DEL FAT-JAR INSTUMENTATO:
## (https://www.jacoco.org/jacoco/trunk/doc/cli.html)

#java -jar ${PATH_JACOCO_CLI_JAR} instrument ${PATH_FJSON_JAR} --dest ${PATH_FJSON_FAT_JAR}

## *****************************************************************
## *****************************************************************

## ESTRAZIONE CON JACOCO DA CLI DEL REPORT:
## (https://www.jacoco.org/jacoco/trunk/doc/cli.html)

mkdir -p target/jacoco-gen/jcs-coverage/

java -jar ${PATH_JACOCO_CLI_JAR} report target/jacoco.exec --classfiles ${PATH_FJSON_JAR} --sourcefiles ${PATH_FJSON_SRC} --html target/jacoco-gen/jcs-coverage/ --xml target/jacoco-gen/jcs-coverage/file.xml --csv target/jacoco-gen/jcs-coverage/file.csv
