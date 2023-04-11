#!/bin/sh

# Eclipse workspace, to be adapted to your own configuration
workspace_dir="RicochetGame"
output_dir="RENDU_PROJET"

# Cleans up previous version
[ -d ${output_dir} ] || mkdir ${output_dir}
rm -rf ${output_dir}/*

# Copies source files
basedir=$(pwd)
cd ${workspace_dir}
find . -name "*.java" -exec cp --parents {} ${basedir}/${output_dir}/ \;
cd - > /dev/null

# Copies scripts
mkdir ${output_dir}/scripts
cp -f scripts/*.sh ${output_dir}/scripts/

# Copies readme
cp README.txt ${output_dir}/

# Makes all files in dist readonly so as to avoid editing them
#find ${output_dir} -type f -exec chmod u-w {} \;
