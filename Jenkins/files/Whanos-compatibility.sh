#!/bin/bash


repository=$1
C_app=false
Java_app=false
JavaScript_app=false
Befunge_app=false
Python_app=false

detection=0
application=none

languages=("C_app" "Java_app" "JavaScript_app" "Befunge_app" "Python_app")

if [ -z "$(ls -A $repository)" ]; then
    echo "Error: The repository contains no files or directories."
    exit 1
fi


if  [ "$(find $repository -type d -name app | wc -l)" -eq 0 ]; then
    echo "Error: The repository must contain an 'app' directory."
    exit 1
fi

# Verification at the root level
for entry in "$repository"/*
do
    if [[ -f "$entry" && "${entry##*/}" == "Makefile" ]]; then
        C_app=true
    fi
    if [[ -f "$entry" && "${entry##*/}" == "package.json" ]]; then
        JavaScript_app=true
    fi
    if [[ -f "$entry" && "${entry##*/}" == "requirements.txt" ]]; then
        Python_app=true
    fi
done


# Verification in the app folder
for entry in "$repository/app"/*
do
    if [[ -f "$entry" && "${entry##*/}" == "main.bf" ]]; then
        Befunge_app=true
    fi
    if [[ -f "$entry" && "${entry##*/}"  == "pom.xml" ]]; then
        Java_app=true
    fi
done

# check multiple detection

for app in "${languages[@]}"; do
    if [ "${!app}" = true ]; then
        echo "$app"
        ((detection+=1))
        application="$app"
    fi
    if [ "$detection" -ge 2 ]; then
        echo "Error: The repository cannot match multiple detection criterion"
        exit 1
    fi
done

echo "$application"