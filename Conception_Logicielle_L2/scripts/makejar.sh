#!/bin/sh

cd $(dirname $0)/..
sh scripts/compile.sh
[ -d jar ] || mkdir jar
cd bin
jar cf ../jar/game.jar .
