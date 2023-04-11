#!/bin/sh

cd $(dirname $0)/..
[ -d bin ] || mkdir bin
javac -d bin src/*/*.java
