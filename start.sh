#!/bin/bash

# This is the script to begin the application.
echo
cd src

# Compiling
echo "Compiling..."
javac Main.java
javac com/brandonmkelley/math/processor/*.java
javac com/brandonmkelley/math/processor/vector/*.java
javac com/brandonmkelley/math/processor/util/*.java
javac com/brandonmkelley/math/datatype/*.java
echo "Done."
echo

# Running
echo "Running program."
echo
java Main $@

# Cleaning
echo
echo "Cleaning up files..."
rm Main.class
rm com/brandonmkelley/math/processor/*.class
rm com/brandonmkelley/math/processor/vector/*.class
rm com/brandonmkelley/math/processor/util/*.class
rm com/brandonmkelley/math/datatype/*.class

# Exiting
echo "Done. Exiting now."
echo
