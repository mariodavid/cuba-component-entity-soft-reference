#!/usr/bin/env bash

./gradlew clean

./gradlew createTestDb
./gradlew check
./gradlew assemble
