#!/bin/bash


repository=$1
C_app
Java_app
JavaScript_app
Befunge_app
Python_app


if [ -z "$(ls -A $repository)" ]; then
    echo "Error: The repository contains no files or directories."
    exit 1
fi


if  [ "$(find $repository -type d -name app)" ]; then
    echo "Error: The repository must contain an 'app' directory."
    exit 1
fi


for entry in "$repository"/*
do
    echo "$entry"
done
