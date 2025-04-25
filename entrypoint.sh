#!/bin/bash

set -e

echo "Cleaning previous app source..."
rm -rf app-source

echo "Cloning fresh source code..."
git clone https://github.com/pashaoleynik97/service-oriented-sys.git app-source

echo "Building the application..."
cd app-source
./gradlew bootJar

echo "Running the application..."
java -jar build/libs/userservice-0.0.1-SNAPSHOT.jar
