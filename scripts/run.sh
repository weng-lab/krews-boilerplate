#!/bin/bash
# Convenience script for running the built application executable jar
# Takes any number of arguments and passes them to the Krews Application

set -e

# cd to project root directory
cd "$(dirname "$0")/.."

java -jar build/*.jar $@