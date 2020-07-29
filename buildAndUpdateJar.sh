#!/bin/sh

targetPath=~/workspaces/spring-jpa-separate/libs


if [ -d $targetPath ]; then
	echo [Info] The Path"("${targetPath}")" is exist
	
	echo [Info] Gradle build
	./gradlew clean shadowJar
	
	echo [info] Copy library
	cp build/libs/spring-jpa-model.jar ${targetPath}/spring-jpa-model.jar
else
	echo [Error] The Path"("${targetPath}")" is not exit
fi

echo [Info] Finish !!
