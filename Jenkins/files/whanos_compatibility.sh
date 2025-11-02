#!/bin/bash

# Initialize an empty array to keep track of detected languages
detected=()

# Check for C
if [ -f "Makefile" ]; then
    detected+=("C")
fi

# Check for Java
if [ -f "app/pom.xml" ]; then
    detected+=("Java")
fi

# Check for Javascript
if [ -f "package.json" ]; then
    detected+=("Javascript")
fi

# Check for Python
if [ -f "requirements.txt" ]; then
    detected+=("Python")
fi

# Check for Befunge
if [ -f "app/main.bf" ]; then
    detected+=("Befunge")
fi

# Evaluate results
if [ ${#detected[@]} -eq 0 ]; then
    echo "No recognized project type found."
    exit 1
elif [ ${#detected[@]} -gt 1 ]; then
    echo "Multiple project types detected: ${detected[*]}"
    exit 1
else
    case "${detected[0]}" in
        C) echo "whanos-c" ;;
        Java) echo "whanos-java" ;;
        Javascript) echo "whanos-javascript" ;;
        Python) echo "whanos-python" ;;
        Befunge) echo "whanos-befunge" ;;
    esac
fi
exit 0
