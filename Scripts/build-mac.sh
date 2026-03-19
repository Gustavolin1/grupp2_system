#!/bin/bash

APP_NAME="MarsTravelsBooking"

#  Mac kräver >=1
VERSION="1.0.0"

#  Din riktiga version
DISPLAY_VERSION="0.1.0"

FINAL_NAME="$APP_NAME-$DISPLAY_VERSION"

ICON="icons/icon.icns"

JPACKAGE="jpackage"
INPUT="target"
MAIN_CLASS="com.example.grupp2_system.App.Launcher"

DEST="builds"

echo "Removing old builds..."
rm -rf "$DEST"/*

echo "Creating builds directory..."
mkdir -p "$DEST"

# Build JAR using Maven wrapper
./mvnw clean package

JAR=$(ls target/*.jar | head -n 1)

echo "Building .dmg..."
$JPACKAGE \
--input "$INPUT" \
--dest "$DEST" \
--name "$FINAL_NAME" \
--app-version "$VERSION" \
--main-jar "$(basename "$JAR")" \
--main-class "$MAIN_CLASS" \
--icon "$ICON" \
--mac-package-name "MarsTravelsBooking" \
--mac-package-identifier "com.marstravels.booking" \
--type dmg

echo "Build completed. Output located in /builds"