#!/usr/bin/env bash

./gradlew clean
./gradlew enhanceTestModel
./gradlew startDb
./gradlew createTestDb
./gradlew check
./gradlew assemble
