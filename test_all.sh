#!/usr/bin/env sh
set -e
#cd ejercicio1
#mvn test
for i in $( ls -d */ ); do
	cd $i
	mvn test
	cd ..
done
